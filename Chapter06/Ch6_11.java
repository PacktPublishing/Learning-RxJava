package ch6;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Ch6_11 {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS,
                Schedulers.newThread())
                .subscribe(i -> System.out.println("Received " + i
                        +
                        " on thread " +
                        Thread.currentThread().getName()));
        sleep(5000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}