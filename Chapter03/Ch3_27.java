package ch3;

import io.reactivex.Observable;

public class Ch3_27 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 11, 2, 14)
                .all(i -> i < 10)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}