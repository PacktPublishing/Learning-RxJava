package ch5;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class Ch5_22 {
    public static void main(String[] args) {
        Subject<String> subject = PublishSubject.create();
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
        subject.map(String::length)
                .subscribe(System.out::println);
    }
}