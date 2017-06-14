package ch2;

import io.reactivex.Observable;

public class Ch2_11 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
//first observer
        source.subscribe(s -> System.out.println("Observer 1 Received: " + s));
//second observer
        source.subscribe(s -> System.out.println("Observer 2 Received: " + s));
    }
}