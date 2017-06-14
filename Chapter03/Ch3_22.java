package ch3;

import io.reactivex.Observable;

public class Ch3_22 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}