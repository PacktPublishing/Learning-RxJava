package ch5;

import io.reactivex.Observable;

public class Ch5_1 {
    public static void main(String[] args) {
        Observable<Integer> threeIntegers = Observable.range(1, 3);
        threeIntegers.subscribe(i -> System.out.println("Observer One: " + i));
        threeIntegers.subscribe(i -> System.out.println("Observer Two: " + i));
    }
}