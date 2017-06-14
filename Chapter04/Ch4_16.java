package ch4;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch4_16 {
    public static void main(String[] args) {
        Observable<Long> source1 =
                Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 =
                Observable.interval(1, TimeUnit.SECONDS);
        source2.withLatestFrom(source1,
                (l1, l2) -> "SOURCE 2: " + l1 + " SOURCE 1: " + l2
        ).subscribe(System.out::println);
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}