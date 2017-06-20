import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

public class Ch10_3 {
    @Test
    public void testBlockingSubscribe() {
        AtomicInteger hitCount = new AtomicInteger();
        Observable<Long> source = Observable.interval(1,
                TimeUnit.SECONDS)
                .take(5);
        source.blockingSubscribe(i -> hitCount.incrementAndGet());
        assertTrue(hitCount.get() == 5);
    }
}
