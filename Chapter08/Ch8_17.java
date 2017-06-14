package ch8;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.atomic.AtomicInteger;

public class Ch8_17 {
    public static void main(String[] args) {
        rangeReverse(100, -100)
                .subscribeOn(Schedulers.computation())
                .doOnNext(i -> System.out.println("Emitting " +
                        i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    sleep(50);
                    System.out.println("Received " + i);
                });
        sleep(50000);
    }

    static Flowable<Integer> rangeReverse(int upperBound, int
            lowerBound) {
        return Flowable.generate(() -> new
                        AtomicInteger(upperBound + 1),
                (state, emitter) -> {
                    int current = state.decrementAndGet();
                    emitter.onNext(current);
                    if (current == lowerBound)
                        emitter.onComplete();
                }
        );
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}