/**
 * @author Sreehitha Kalagara
 * @version 1.0
 * @param <T> generic type
 */
public class Person<T> {
    private T parcel;
    private Person<T> nextPerson;
    /**
     * Person object constructor.
     * @param parcel the parcel of type T that the person is holding
     * @param nextPerson a reference to the nextPerson in line
     * @throws IllegalArgumentException if parcel is null
     */
    public Person(T parcel, Person<T> nextPerson) throws IllegalArgumentException {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel cannot be null");
        }
        this.parcel = parcel;
        this.nextPerson = nextPerson;
    }
    /**
     * Person object constructor.
     * @param parcel the parcel of type T that the person is holding
     * @throws IllegalArgumentException if parcel is null
     */
    public Person(T parcel) throws IllegalArgumentException {
        this(parcel, null);
    }
    /**
     * An accessor method for parcel.
     * @return parcel
     */
    public T getParcel() {
        return parcel;
    }
    /**
     * An accessor method for nextPerson.
     * @return nextPerson
     */
    public Person getNextPerson() {
        return nextPerson;
    }
    /**
     * A setter method for parcel.
     * @param parcel new value of parcel
     */
    public void setParcel(T parcel) {
        this.parcel = parcel;
    }
    /**
     * A setter method for nextPerson.
     * @param nextPerson new value of nextPerson
     */
    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }
}
