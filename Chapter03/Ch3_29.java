package ch3;

import io.reactivex.Observable;

public class Ch3_29 {
    public static void main(String[] args) {
        Observable.range(1, 10000)
                .contains(9563)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}