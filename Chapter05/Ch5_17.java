package ch5;

import io.reactivex.Observable;

public class Ch5_17 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma",
                        "Delta", "Epsilon")
                        .replay(1)
                        .autoConnect();
//Observer 1
        source.subscribe(l -> System.out.println("Observer 1: " +
                l));
//Observer 2
        source.subscribe(l -> System.out.println("Observer 2: " +
                l));
    }
}