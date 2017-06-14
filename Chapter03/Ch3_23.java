package ch3;

import io.reactivex.Observable;

public class Ch3_23 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .scan(0, (total, next) -> total + 1)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}