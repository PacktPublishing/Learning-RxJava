package ch7;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Ch7_15 {
    public static void main(String[] args) {
        Observable<String> items = Observable.just("Alpha", "Beta",
                "Gamma", "Delta", "Epsilon",
                "Zeta", "Eta", "Theta", "Iota");
//delay each String to emulate an intense calculation
        Observable<String> processStrings = items.concatMap(s ->
                Observable.just(s)
                        .delay(randomSleepTime(),
                                TimeUnit.MILLISECONDS)
        );
//run processStrings every 5 seconds, and kill eachprevious instance to start next
        Observable.interval(5, TimeUnit.SECONDS)
                .switchMap(i ->
                        processStrings
                                .doOnDispose(() ->
                                        System.out.println("Disposing! Starting next"))
                ).subscribe(System.out::println);
//keep application alive for 20 seconds
        sleep(20000);
    }

    public static int randomSleepTime() {
//returns random sleep time between 0 to 2000 milliseconds
        return ThreadLocalRandom.current().nextInt(2000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}