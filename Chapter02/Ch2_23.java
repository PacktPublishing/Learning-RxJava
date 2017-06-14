package ch2;

import io.reactivex.Observable;

public class Ch2_23 {
    public static void main(String[] args) {
        Observable.error(() -> new Exception("Crash and burn!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }
}