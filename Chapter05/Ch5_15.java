package ch5;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch5_15 {
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        .refCount();
//Observer 1
        seconds.take(5)
                .subscribe(l -> System.out.println("Observer 1: " +
                        l));
        sleep(3000);
//Observer 2
        seconds.take(2)
                .subscribe(l -> System.out.println("Observer 2: " +
                        l));
        sleep(3000);
//there should be no more Observers at this point
//Observer 3
        seconds.subscribe(l -> System.out.println("Observer 3: " +
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