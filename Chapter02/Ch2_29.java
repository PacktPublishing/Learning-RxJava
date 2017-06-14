package ch2;

import io.reactivex.Observable;

public class Ch2_29 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma");
        source.first("Nil") //returns a Single
                .subscribe(System.out::println);
    }
}