import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Ch10_12 {
    @Test
    public void usingTestObserver() {
        //An Observable with 5 one-second emissions
        Observable<Long> source = Observable.interval(1,
                TimeUnit.SECONDS)
                .take(5);

        //Declare TestObserver
        TestObserver<Long> testObserver = new TestObserver<>();

        //Assert no subscription has occurred yet
        testObserver.assertNotSubscribed();

        //Subscribe TestObserver to source
        source.subscribe(testObserver);

        //Assert TestObserver is subscribed
        testObserver.assertSubscribed();

        //Block and wait for Observable to terminate
        testObserver.awaitTerminalEvent();

        //Assert TestObserver called onComplete()
        testObserver.assertComplete();

        //Assert there were no errors
        testObserver.assertNoErrors();

        //Assert 5 values were received
        testObserver.assertValueCount(5);

        //Assert the received emissions were 0, 1, 2, 3, 4
        testObserver.assertValues(0L, 1L, 2L, 3L, 4L);
    }
}
