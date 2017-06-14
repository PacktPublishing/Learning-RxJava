package ch4;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class Ch4_18 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(s -> s.length());
        byLengths.flatMapSingle(grp -> grp.toList())
                .subscribe(System.out::println);
    }
}