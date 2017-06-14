package ch4;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class Ch4_17 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(s -> s.length());
    }
}