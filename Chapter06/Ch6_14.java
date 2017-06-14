package ch6;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Ch6_14 {
    public static void main(String[] args) {
//Happens on IO Scheduler
        Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO",
                "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())
                .flatMap(s -> Observable.fromArray(s.split("/")))
                .doOnNext(s -> System.out.println("Split out " + s
                        + " on thread "
                        + Thread.currentThread().getName()))
//Happens on Computation Scheduler
                .observeOn(Schedulers.computation())
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce((total, next) -> total + next)
                .doOnSuccess(i -> System.out.println("Calculated sum" + i + " on thread"
                                + Thread.currentThread().getName()))
//Switch back to IO Scheduler
                .observeOn(Schedulers.io())
                .map(i -> i.toString())
                .doOnSuccess(s -> System.out.println("Writing " + s
                        + " to file on thread "
                        + Thread.currentThread().getName()))
                .subscribe(s ->
                        write(s, "/home/thomas/Desktop/output.txt"));
        sleep(1000);
    }

    public static void write(String text, String path) {
        BufferedWriter writer = null;
        try {
//create a temporary file
            File file = new File(path);
            writer = new BufferedWriter(new FileWriter(file));
            writer.append(text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}