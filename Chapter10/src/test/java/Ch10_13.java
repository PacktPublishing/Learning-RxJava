import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Ch10_13 {
    @Test
    public void usingTestScheduler() {

        //Declare TestScheduler
        TestScheduler testScheduler = new TestScheduler();

        //Declare TestObserver
        TestObserver<Long> testObserver = new TestObserver<>();

        //Declare Observable emitting every 1 minute
        Observable<Long> minuteTicker =
                Observable.interval(1, TimeUnit.MINUTES,
                        testScheduler);

        //Subscribe to TestObserver
        minuteTicker.subscribe(testObserver);

        //Fast forward by 30 seconds
        testScheduler.advanceTimeBy(30, TimeUnit.SECONDS);

        //Assert no emissions have occurred yet
        testObserver.assertValueCount(0);

        //Fast forward to 70 seconds after subscription
        testScheduler.advanceTimeTo(70, TimeUnit.SECONDS);

        //Assert the first emission has occurred
        testObserver.assertValueCount(1);

        //Fast Forward to 90 minutes after subscription
        testScheduler.advanceTimeTo(90, TimeUnit.MINUTES);

        //Assert 90 emissions have occurred
        testObserver.assertValueCount(90);
    }
}
