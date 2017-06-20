package packtpub.com.rxjavaapp;

import org.junit.Test;

import java.util.concurrent.Callable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void lambdaTest() throws Exception {
        Callable<Integer> callable = () -> 4;
        System.out.println(callable.call());
    }
}