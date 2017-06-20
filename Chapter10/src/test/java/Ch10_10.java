import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Ch10_10 {
    @Test
    public void testBlockingLatest() {
        Observable<Long> source =
                Observable.interval(1, TimeUnit.MICROSECONDS)
                        .take(1000);

        Iterable<Long> iterable = source.blockingLatest();

        for (Long i: iterable) {
            System.out.println(i);
        }
    }
}
