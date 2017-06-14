package ch9;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.functions.Action;
import io.reactivex.subscribers.DisposableSubscriber;
import org.reactivestreams.Subscriber;

public class Ch9_9 {
    public static void main(String[] args) {
        Flowable.range(1, 5)
                .lift(doOnEmpty(() ->
                        System.out.println("Operation 1 Empty!")))
                .subscribe(v -> System.out.println("Operation 1: "
                        + v));
        Flowable.<Integer>empty()
                .lift(doOnEmpty(() ->
                        System.out.println("Operation 2 Empty!")))
                .subscribe(v -> System.out.println("Operation 2: "
                        + v));
    }

    public static <T> FlowableOperator<T, T> doOnEmpty(Action
                                                               action) {
        return new FlowableOperator<T, T>() {
            @Override
            public Subscriber<? super T> apply(Subscriber<? super
                    T> subscriber) throws Exception {
                return new DisposableSubscriber<T>() {
                    boolean isEmpty = true;

                    @Override
                    public void onNext(T value) {
                        isEmpty = false;
                        subscriber.onNext(value);
                    }

                    @Override
                    public void onError(Throwable t) {
                        subscriber.onError(t);
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
                        subscriber.onComplete();
                    }
                };
            }
        };
    }
}