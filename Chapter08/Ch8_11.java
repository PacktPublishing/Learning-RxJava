package ch8;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Ch8_11 {
    public static void main(String[] args) {
        Flowable<Integer> integers =
                Flowable.range(1, 1000)
                        .subscribeOn(Schedulers.computation());
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .flatMap(s -> integers.map(i -> i + "-" +
                        s).toObservable())
                .subscribe(System.out::println);
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