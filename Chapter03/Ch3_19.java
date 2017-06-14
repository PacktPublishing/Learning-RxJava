package ch3;

import io.reactivex.Observable;

public class Ch3_19 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .sorted((x, y) -> Integer.compare(x.length(), y.length()))
                .subscribe(System.out::println);
    }
}