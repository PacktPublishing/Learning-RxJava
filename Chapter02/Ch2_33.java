package ch2;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Ch2_33 {
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable =
                seconds.subscribe(l -> System.out.println("Received: " + l));
//sleep 5 seconds
        sleep(5000);
//dispose and stop emissions
        disposable.dispose();
//sleep 5 seconds to prove
//there are no more emissions
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