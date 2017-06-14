package ch2;

import io.reactivex.Observable;

public class Ch2_20 {
    public static void main(String[] args) {
        Observable<String> empty = Observable.empty();
        empty.subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));
    }
}