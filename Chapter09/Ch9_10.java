package ch9;

import io.reactivex.Observable;
import io.reactivex.SingleTransformer;

import java.util.Collection;
import java.util.Collections;

public class Ch9_10 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toList()
                .compose(toUnmodifiable())
                .subscribe(System.out::println);
    }

    public static <T> SingleTransformer<Collection<T>,
            Collection<T>> toUnmodifiable() {
        return singleObserver ->
                singleObserver.map(Collections::unmodifiableCollection);
    }
}