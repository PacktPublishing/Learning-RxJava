package ch2;

import io.reactivex.Single;

public class Ch2_28 {
    public static void main(String[] args) {
        Single.just("Hello")
                .map(String::length)
                .subscribe(System.out::println,
                        Throwable::printStackTrace);
    }
}