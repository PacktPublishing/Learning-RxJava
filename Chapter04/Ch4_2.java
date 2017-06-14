package ch4;

import io.reactivex.Observable;

public class Ch4_2 {
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta");
        Observable<String> source2 =
                Observable.just("Gamma", "Delta");
        Observable<String> source3 =
                Observable.just("Epsilon", "Zeta");
        Observable<String> source4 =
                Observable.just("Eta", "Theta");
        Observable<String> source5 =
                Observable.just("Iota", "Kappa");
        Observable.mergeArray(source1, source2, source3, source4,
                source5)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}