package ch5;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Ch5_2 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> threeIntegers =
                Observable.range(1, 3).publish();
        threeIntegers.subscribe(i -> System.out.println("Observer One:" + i));
        threeIntegers.subscribe(i -> System.out.println("Observer Two:" + i));
        threeIntegers.connect();
    }
}