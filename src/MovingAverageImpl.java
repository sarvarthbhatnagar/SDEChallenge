import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * <p>This implementation of {@link IMovingAverageAware} uses an ordered data structure
 * offering quick insertion and retrieval of last N elements
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a linked list concurrently, and at least
 * one of the threads modifies the list structurally, it <i>must</i> be
 * synchronized externally.  (A structural modification is any operation
 * that adds or deletes one or more elements; merely setting the value of
 * an element is not a structural modification.)  This is typically
 * accomplished by synchronizing on some object that naturally
 * encapsulates the list.
 */
public class MovingAverageImpl implements IMovingAverageAware<Double> {

    private final LinkedList<Double> _maQueue;

    public MovingAverageImpl() {
        _maQueue = new LinkedList<>();
    }

    @Override
    public void add(Double element) {
        _maQueue.addLast(element);

    }

    @Override
    public Double getMovingAverage(int N) {

        if (N < 0) {
            throw new IllegalArgumentException("Moving average calculation disallows negative inputs");
        }

        if (_maQueue.isEmpty() || N == 0) {
            return 0.0;
        }

        final int cappedN = Math.min(_maQueue.size(), N);
        final Iterator<Double> maIterator = _maQueue.descendingIterator();
        double ma = 0.0;
        for (int i = 0; i < cappedN; i++) {
            ma += maIterator.next();
        }
        return ma / cappedN;
    }

    @Override
    public Collection<Double> getElements() {
        return _maQueue;
    }

    /**
     * Gets the number of underlying elements
     * For use in unit tests
     * @return
     */
    public int getSize() {
        return _maQueue.size();
    }
}
