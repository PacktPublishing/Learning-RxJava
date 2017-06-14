package ch9;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.observers.DisposableObserver;

import java.util.ArrayList;
import java.util.List;

public class Ch9_8 {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .lift(myToList())
                .subscribe(v -> System.out.println("Operation 1: "
                        + v));
        Observable.<Integer>empty()
                .lift(myToList())
                .subscribe(v -> System.out.println("Operation 2: "
                        + v));
    }

    public static <T> ObservableOperator<List<T>, T> myToList() {
        return observer -> new DisposableObserver<T>() {
            ArrayList<T> list = new ArrayList<>();

            @Override
            public void onNext(T value) {
//add to List, but don't pass anything downstream
                list.add(value);
            }

            @Override
            public void onError(Throwable t) {
                observer.onError(t);
            }

            @Override
            public void onComplete() {
                observer.onNext(list); //push List downstream
                observer.onComplete();
            }
        };
    }
}