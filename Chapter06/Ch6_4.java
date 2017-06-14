package ch6;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class Ch6_4 {
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                        .subscribeOn(Schedulers.computation())
                        .map(s -> intenseCalculation((s)));
        Observable<Integer> source2 =
                Observable.range(1, 6)
                        .subscribeOn(Schedulers.computation())
                        .map(s -> intenseCalculation((s)));
        Observable.zip(source1, source2, (s, i) -> s + "-" + i)
                .subscribe(System.out::println);
        sleep(20000);
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}