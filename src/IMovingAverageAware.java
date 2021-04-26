import java.util.Collection;

/**
 * <p></>Provides the contract for calculating moving averages of the last N elements added,
 * add elements get access to the inserted elements.
 * <p></>The underlying data structure of type {@link Collection} should be able to support these operations
 * <p>For further information on calculation of moving averages refer -
 * <a href="https://en.wikipedia.org/wiki/Moving_average">
 * Moving Averages Wikipedia Doc</a>.
 */
public interface IMovingAverageAware<T> {


    /**
     * Append an element at the end of the underlying datastructure
     *
     * @param element
     */
    void add(T element);


    /**
     * Gets moving averages of the last N elements.
     *
     * @param N last N number of elements for which moving average needs to be calculated
     * @return
     */
    T getMovingAverage(int N);


    /**
     * Provides access to the underlying data structure
     *
     * @return
     */
    Collection<T> getElements();

}
