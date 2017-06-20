import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Ch10_9 {
    @Test
    public void testBlockingNext() {
        Observable<Long> source =
                Observable.interval(1, TimeUnit.MICROSECONDS)
                        .take(1000);
        Iterable<Long> iterable = source.blockingNext();
        for (Long i: iterable) {
            System.out.println(i);
        }
    }
}
