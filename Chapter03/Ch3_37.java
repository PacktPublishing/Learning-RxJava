package ch3;

import io.reactivex.Observable;

public class Ch3_37 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(String::length)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}