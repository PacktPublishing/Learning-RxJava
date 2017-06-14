package ch3;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;

public class Ch3_40 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .collect(ImmutableList::builder,
                        ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}