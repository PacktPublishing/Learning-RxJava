package ch5;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;

public class Ch5_25 {
    public static void main(String[] args) {
        Subject<String> subject =
                AsyncSubject.create();
        subject.subscribe(s ->
                        System.out.println("Observer 1: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Observer 1 done!")
        );
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
        subject.subscribe(s ->
                        System.out.println("Observer 2: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Observer 2 done!")
        );
    }
}