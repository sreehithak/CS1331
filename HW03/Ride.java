/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public abstract class Ride {
    /** String representing the identifier for the ride. */
    protected final String id;
    /** double representing the total amount of money this ride has earned that day. */
    protected double earnings;
    /** int representing the number of times the ride has run since the last inspection */
    protected int runsSinceInspection;
    /** An array of Strings representing the passengers aboard the ride.
     * Each String in the array represents a passengers name. */
    protected String[] passengers;
    /**
     * A Ride object contructor that takes in id, runsSinceInspection, passengers, and intializes earnings to 0.
     * @param id identifier for ride.
     * @param runsSinceInspection number of times the ride has runs since last inspection.
     * @param passengers array of Strings that represents the passengers on a ride.
     */
    public Ride(String id, int runsSinceInspection, String[] passengers) {
        this.id = id;
        this.runsSinceInspection = runsSinceInspection;
        this.passengers = new String[passengers.length];
        for (int i = 0; i < passengers.length; i++) {
            this.passengers[i] = passengers[i];
        }
        this.earnings = 0;
    }
    /**
     * A Ride object contructor that takes in id, passengers, and intializes earnings and runsSinceInspection to 0.
     * @param id identifier for ride.
     * @param passengers array of Strings that represents the passengers on a ride.
     */
    public Ride(String id, String[] passengers) {
        this(id, 0, passengers);
    }
    /**
     * Method that tells user whether or not a ride can run.
     * @param numRuns the number of runs
     * @return boolean that represents whether the ride can ride that many times without inspection.
     */
    public abstract boolean canRun(int numRuns);
    /**
     * Method that tells the user if the ride passes an ispection.
     * @param rideComponents different components of the ride
     * @return boolean that represents whether or not the ride passed the inspection
     */
    public abstract boolean inspectRide(String[] rideComponents);
    /**
     * Method that calculates the cost for the passenger to ride to the specified number of stops.
     * @param numStops number of stops the passenger will ride
     * @return the cost for that passenger
     */
    public abstract double costPerPassenger(int numStops);
    /**
     * Tells the user whether or not all of the passengers were added to the ride.
     * @param numStops number of stops
     * @param passengerNames names of the passengers being added to the ride
     * @return boolean that represents whether or not the passengers were able to be added
     */
    public abstract boolean addPassengers(int numStops, String[] passengerNames);
    /**
     * Method that gives the user a String representation of the passengers on the ride.
     * @return a String that represents a list of passengers on the ride
     */
    public String getPassengerList() {
        String str = String.format("Passenger List for %s:", id);
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                continue;
            } else {
                str += String.format("%n%s", passengers[i]);
            }
        }
        return str;
    }
    /**
     * Updates the amount a ride has earned.
     * @param numStops the number of stops
     */
    public void chargePassenger(int numStops) {
        earnings += costPerPassenger(numStops);
    }
    /**
     * Removes the first occurence of a passenger's name from the passenger list.
     * @param name name of the passenger being removed
     * @return a boolean value that represents whether or not the passenger was in the list and has been removed
     */
    public boolean removePassenger(String name) {
        for (int i = 0; i < passengers.length; i++) {
            if (name.equals(passengers[i])) {
                passengers[i] = null;
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other instanceof Ride) {
            Ride newobj = (Ride) other;
            return newobj.id.equals(this.id) && newobj.runsSinceInspection == this.runsSinceInspection;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("%s has run %d times and has earned $%.2f.", id, runsSinceInspection, earnings);
    }
}