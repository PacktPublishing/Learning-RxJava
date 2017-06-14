package ch4;

import io.reactivex.Observable;

public class Ch4_8 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.flatMap(s -> Observable.fromArray(s.split("")),
                (s, r) ->
                        s + "-" + r)
                .subscribe(System.out::println);
    }
}