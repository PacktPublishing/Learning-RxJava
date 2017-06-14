package ch8;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static ch5.Ch5_21.sleep;

public class Ch8_8 {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isDisposed())
                    return;
                emitter.onNext(i);
            }
            emitter.onComplete();
        });
        source.observeOn(Schedulers.io())
                .subscribe(System.out::println);
        sleep(1000);
    }
}