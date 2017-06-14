package ch3;

import io.reactivex.Observable;

public class Ch3_11 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
                "Delta")
                .elementAt(3)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}