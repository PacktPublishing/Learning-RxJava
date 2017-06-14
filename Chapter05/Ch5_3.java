package ch5;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_3 {
    public static void main(String[] args) {
        Observable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt());
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        threeRandoms.subscribe(i -> System.out.println("Observer 2: " + i));
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}