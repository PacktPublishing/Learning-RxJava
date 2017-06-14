package ch7;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch7_7 {
    public static void main(String[] args) {
        Observable<Long> cutOffs =
                Observable.interval(1, TimeUnit.SECONDS);
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .buffer(cutOffs)
                .subscribe(System.out::println);
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