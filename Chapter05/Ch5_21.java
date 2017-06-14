package ch5;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

import java.util.concurrent.TimeUnit;

public class Ch5_21 {
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.interval(1, TimeUnit.SECONDS)
                        .map(l -> (l + 1) + " seconds");
        Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> ((l + 1) * 300) + " milliseconds");
        Subject<String> subject = PublishSubject.create();
        subject.subscribe(System.out::println);
        source1.subscribe(subject);
        source2.subscribe(subject);
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}