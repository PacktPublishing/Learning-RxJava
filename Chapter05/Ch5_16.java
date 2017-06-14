package ch5;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch5_16 {
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .replay()
                        .autoConnect();
//Observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " +
                l));
        sleep(3000);
//Observer 2
        seconds.subscribe(l -> System.out.println("Observer 2: " +
                l));
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