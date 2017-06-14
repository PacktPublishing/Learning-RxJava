package ch2;

import io.reactivex.Observable;

public class Ch2_31 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source.firstElement().subscribe(
                s -> System.out.println("RECEIVED " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));
    }
}