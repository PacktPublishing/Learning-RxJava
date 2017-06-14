package ch2;

import io.reactivex.Observable;

public class Ch2_15 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}