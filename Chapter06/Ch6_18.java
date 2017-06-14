package ch6;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Ch6_18 {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        AtomicInteger assigner = new AtomicInteger(0);
        Observable.range(1, 10)
                .groupBy(i -> assigner.incrementAndGet() %
                        coreCount)
                .flatMap(grp -> grp.observeOn(Schedulers.io())
                        .map(i2 -> intenseCalculation(i2))
                )
                .subscribe(i -> System.out.println("Received " + i +
                        " "
                        + LocalTime.now() + " on thread "
                        + Thread.currentThread().getName()));
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