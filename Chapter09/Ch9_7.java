package ch9;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableObserver;

public class Ch9_7 {
    public static void main(String[] args) {
        Observable.range(1, 5)
                .lift(doOnEmpty(() ->
                        System.out.println("Operation 1 Empty!")))
                .subscribe(v -> System.out.println("Operation 1: "
                        + v));
        Observable.<Integer>empty()
                .lift(doOnEmpty(() ->
                        System.out.println("Operation 2 Empty!")))
                .subscribe(v -> System.out.println("Operation 2: "
                        + v));
    }

    public static <T> ObservableOperator<T, T> doOnEmpty(Action
                                                                 action) {
        return new ObservableOperator<T, T>() {
            @Override
            public Observer<? super T> apply(Observer<? super T>
                                                     observer) throws Exception {
                return new DisposableObserver<T>() {
                    boolean isEmpty = true;

                    @Override
                    public void onNext(T value) {
                        isEmpty = false;
                        observer.onNext(value);
                    }

                    @Override
                    public void onError(Throwable t) {
                        observer.onError(t);
                    }

                    @Override
                    public void onComplete() {
                        if (isEmpty) {
                            try {
                                action.run();
                            } catch (Exception e) {
                                onError(e);
                                return;
                            }
                        }
                        observer.onComplete();
                    }
                };
            }
        };
    }
}