package ch6;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Ch6_19 {
    public static void main(String[] args) {
        Disposable d = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposing on thread"
                                + Thread.currentThread().getName()))
                .subscribe(i -> System.out.println("Received " +
                        i));
        sleep(3000);
        d.dispose();
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