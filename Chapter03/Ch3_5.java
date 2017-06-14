package ch3;

import io.reactivex.Observable;

public class Ch3_5 {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .takeWhile(i -> i < 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}