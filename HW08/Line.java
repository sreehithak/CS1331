import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 * @param <T> generic type
 */
public class Line<T> implements List<T> {

    private Person<T> firstPerson;
    private int size;

    /**
     * Line object constructor.
     * @param parcel that the person in line is holding
     */
    public Line(T[] parcel) {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel cannot be null.");
        }
        for (int i = 0; i < parcel.length; i++) {
            if (parcel[i] == null) {
                throw new IllegalArgumentException("Parcel cannot contain null elements.");
            }
            add(parcel[i]);
        }
    }

    /**
     * Line object constructor.
     */
    public Line() {
        this.size = 0;
        this.firstPerson = null;
    }

    /**
     * Accessor method for firstPerson.
     * @return firstPerson
     */
    public Person<T> getFirstPerson() {
        return firstPerson;
    }

    /**
     * Converts the linked list into arrays.
     * @return an array of parcels
     */
    public T[] toArray() {
        if (size == 0) {
            return (T[]) new Object[0];
        }
        T[] arr = (T[]) new Object[size];
        int i = 0;
        Iterator<T> itr = this.iterator();
        while (itr.hasNext()) {
            arr[i++] = itr.next();
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINE %d =====\nisEmpty: %b\nsize: %d\nfirstPerson: %s\n: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (firstPerson == null ? "null" : firstPerson.getParcel())));

        T[] people = toArray();
        if (people == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < people.length - 1; ++i) {
                sb.append(String.format("%s, ", people[i])); // append all but last value
            }
            if (people.length > 0) {
                sb.append(String.format("%s", people[people.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null!");
        } else if (isEmpty()) {
            firstPerson = new Person<T>(element);
        } else {
            Person<T> thisPerson = firstPerson;
            while (thisPerson.getNextPerson() != null) {
                thisPerson = thisPerson.getNextPerson();
            }
            Person<T> temp = new Person(element);
            thisPerson.setNextPerson(temp);
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("The index passed in is invalid!");
        } else if (element == null) {
            throw new IllegalArgumentException("The parcel cannot be null");
        } else if (index == 0) {
            Person<T> temp = firstPerson;
            firstPerson = new Person(element, temp);
            size++;
        } else if (index == size) {
            add(element);
        } else {
            Person<T> personBefore = firstPerson;
            for (int i = 1; i < index; i++) {
                personBefore = personBefore.getNextPerson();
            }
            Person<T> personAfter = personBefore.getNextPerson();
            Person<T> newPerson = new Person(element, personAfter);
            personBefore.setNextPerson(newPerson);
            size++;
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("The line is empty!");
        } else if (size == 1) {
            Person<T> per = firstPerson;
            firstPerson = null;
            size--;
            return per.getParcel();
        } else {
            Person<T> per = firstPerson;
            firstPerson = firstPerson.getNextPerson();
            size--;
            return per.getParcel();
        }
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new NoSuchElementException("The line is empty!");
        } else if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("The inputted index is invalid!");
        } else if (index == 0) {
            return remove();
        } else if (index == (size - 1)) {
            Person<T> lastPerson = firstPerson;
            for (int i = 1; i < (size - 1); i++) {
                lastPerson = lastPerson.getNextPerson();
            }
            size--;
            Person<T> returnPerson = lastPerson.getNextPerson();
            lastPerson.setNextPerson(null);
            return returnPerson.getParcel();
        } else {
            Person<T> beforePerson = firstPerson;
            for (int i = 1; i < index; i++) {
                beforePerson = beforePerson.getNextPerson();
            }
            Person<T> removedPerson = beforePerson.getNextPerson();
            Person<T> afterPerson = removedPerson.getNextPerson();
            beforePerson.setNextPerson(afterPerson);
            size--;
            return removedPerson.getParcel();
        }
    }

    @Override
    public T remove(T element) throws NoSuchElementException, IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null!");
        } else if (!contains(element)) {
            throw new NoSuchElementException("Element is not in list!");
        } else if (firstPerson.getParcel().equals(element)) {
            T returnParcel = firstPerson.getParcel();
            firstPerson = firstPerson.getNextPerson();
            size--;
            return returnParcel;
        } else {
            Person<T> beforePerson = firstPerson;
            while (beforePerson.getNextPerson() != null) {
                if (beforePerson.getNextPerson().getParcel().equals(element)) {
                    break;
                }
                beforePerson = beforePerson.getNextPerson();
            }
            size--;
            Person<T> removedPerson = beforePerson.getNextPerson();
            beforePerson.setNextPerson(removedPerson.getNextPerson());
            return removedPerson.getParcel();
        }
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null!");
        } else if (isEmpty()) {
            return false;
        } else {
            Person<T> thisPerson = firstPerson;
            while (thisPerson != null) {
                if (thisPerson.getParcel().equals(element)) {
                    return true;
                }
                thisPerson = thisPerson.getNextPerson();
            }
            return false;
        }
    }
    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("The inputted index is invalid!");
        } else if (element == null) {
            throw new IllegalArgumentException("Element cannot be null!");
        } else if (index == 0) {
            Person<T> temp = firstPerson;
            firstPerson = new Person(element, temp.getNextPerson());
            return temp.getParcel();
        } else if (index == (size - 1)) {
            Person<T> beforePerson = firstPerson;
            for (int i = 1; i < index; i++) {
                beforePerson = beforePerson.getNextPerson();
            }
            Person<T> replacedPerson = beforePerson.getNextPerson();
            beforePerson.setNextPerson(new Person(element));
            return replacedPerson.getParcel();
        } else {
            Person<T> beforePerson = firstPerson;
            for (int i = 1; i < index; i++) {
                beforePerson = beforePerson.getNextPerson();
            }
            Person<T> replacedPerson = beforePerson.getNextPerson();
            beforePerson.setNextPerson(new Person(element, replacedPerson.getNextPerson()));
            return replacedPerson.getParcel();
        }
    }

    @Override
    public void clear() {
        this.firstPerson = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LineIterator(this);
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("The inputted index is invalid!");
        }
        Iterator<T> itr = this.iterator();
        int i = 0;
        while (itr.hasNext() && i < index) {
            itr.next();
            i++;
        }
        return itr.next();
    }

    /**
     * Method that reverses the linked list.
     */
    public void reverse() {
        if (this == null || isEmpty() || size == 1) {
            return;
        } else {
            reverseHelper(null, firstPerson);
        }
    }

    /**
     * Helper method for the reverse method that reverses the linked list in place using recursion.
     * @param prev the previous Person in line
     * @param current the current Person in line
     * @return a Person whos nextPerson has been set to their previous person
     */
    private Person reverseHelper(Person<T> prev, Person<T> current) {
        if (current.getNextPerson() == null) {
            firstPerson = current;
            current.setNextPerson(prev);
            return current;
        }
        Person<T> aPerson = reverseHelper(current, current.getNextPerson());
        current.setNextPerson(prev);
        return aPerson;
    }
}