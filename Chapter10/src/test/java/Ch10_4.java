import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

public class Ch10_4 {
    @Test
    public void testFirst() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Zeta");
        String firstWithLengthFour = source.filter(s -> s.length()
                == 4)
                .blockingFirst();
        assertTrue(firstWithLengthFour.equals("Beta"));
    }
}
