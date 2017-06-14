package ch3;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch3_20 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .delay(3, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println("Received: " + s));
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}