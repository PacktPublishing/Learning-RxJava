package ch6;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch6_6 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(Ch6_6::intenseCalculation)
                .blockingSubscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}