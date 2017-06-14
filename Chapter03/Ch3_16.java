package ch3;

import io.reactivex.Observable;

public class Ch3_16 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .filter(s -> s.startsWith("Z"))
                .switchIfEmpty(Observable.just("Zeta", "Eta", "Theta"))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}