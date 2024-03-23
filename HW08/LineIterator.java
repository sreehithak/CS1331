import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 * @param <T> generic type
 */
public class LineIterator<T> implements Iterator<T> {
    private Person<T> nextPerson;
    /**
     * LineIterator object constructor.
     * @param line the line object being traversed
     * @throws IllegalArgumentException if the line is null
     */
    public LineIterator(Line<T> line) throws IllegalArgumentException {
        if (line == null) {
            throw new IllegalArgumentException("Line cannot be null");
        } else {
            this.nextPerson = line.getFirstPerson();
        }
    }
    /**
     * method that tells user whether or not there is a nextPerson in line.
     * @return whether or not there is a nextPerson in line
     */
    public boolean hasNext() {
        if (nextPerson == null) {
            return false;
        }
        return true;
    }
    /**
     * Moves the iterator to the next person in the list.
     * @return the parcel of the nextPerson in line
     */
    public T next() throws NoSuchElementException {
        if (hasNext()) {
            Person<T> thisPerson = nextPerson;
            nextPerson = nextPerson.getNextPerson();
            return (T) thisPerson.getParcel();
        } else {
            throw new NoSuchElementException("No next element!");
        }
    }
}