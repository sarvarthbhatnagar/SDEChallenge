import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovingAverageTest {

    private final MovingAverageImpl maImpl = new MovingAverageImpl();

    @Before
    public void populateMA() {
        maImpl.add(1000.25);
        maImpl.add(2000.75);
        maImpl.add(3000.30);
        maImpl.add(2000.10);
    }

    @Test
    public void addTest() {
        String str = "Failure: Inserted %d elements and found %d";
        int maLength = maImpl.getSize();
        int expectedCount = 4;
        assertTrue(String.format(str, expectedCount, maLength), expectedCount == maLength);
    }

    @Test
    public void getMovingAverageTest() {
        String str = "Failure: Expected MA: %f, found:  %f";

        /**
         * checks for 0, should not lead to divideByZero condition
         */
        double expected0 = 0d;
        double ma0 = maImpl.getMovingAverage(0);
        assertTrue(String.format(str, expected0, ma0), expected0 == ma0);

        /**
         * checks for range within the collection size
         */
        double expected3 = 2333.71;
        double ma3 = maImpl.getMovingAverage(3);
        assertEquals(String.format(str, expected3, ma3), expected3, ma3, 0.01);

        /**
         * checks for range greater than the collection size
         */
        double expectedCount5 = 2000.35;
        double ma5 = maImpl.getMovingAverage(5);
        assertEquals(String.format(str, expectedCount5, ma5), expectedCount5, ma5, 0.01);
    }

    /**
     * Negative input test case, guards against method misuse
     */
    @Test(expected = IllegalArgumentException.class)
    public void getMovingAverageNegativeTest() {
        maImpl.getMovingAverage(-1);
    }


    @Test
    public void getElementsTest() {
        Collection<Double> elements = maImpl.getElements();
        String str = "Failure: Expected %d elements and found %d";
        int maLength = elements.size();
        int expectedCount = 4;
        assertTrue(String.format(str, expectedCount, maLength), expectedCount == maLength);
    }

}