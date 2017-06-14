package ch7;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch7_5 {
    public static void main(String[] args) {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        sleep(4000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}