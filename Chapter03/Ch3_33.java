package ch3;

import io.reactivex.Observable;

public class Ch3_33 {
    public static void main(String[] args) {
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .toSortedList()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}