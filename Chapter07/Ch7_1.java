package ch7;

import io.reactivex.Observable;

public class Ch7_1 {
    public static void main(String[] args) {
        Observable.range(1, 50)
                .buffer(8)
                .subscribe(System.out::println);
    }
}