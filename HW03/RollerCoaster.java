/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class RollerCoaster extends Ride {
    /** double representing the price of one run. */
    private double rate;
    /** double representing the price of the mandatory photo package (only applied once). */
    private double photoFees;
    /** int representing the total number of times that ride can run before inspection. */
    private int maxNumRuns;
    /**
     * A RollerCoaster object contructor.
     * @param id String representing the identifier for the ride
     * @param runsSinceInspection int representing the number of times the ride has run since the last inspection
     * @param passengers An array of Strings representing the passengers aboard the ride.
     * Each String in the array represents a passengers name.
     * @param rate double representing the price of one run
     * @param photoFees double represnting the price of the mandatory photo package
     * @param maxNumRuns int representing the total number of times that ride can run
     */
    public RollerCoaster(String id, int runsSinceInspection, String[] passengers,
        double rate, double photoFees, int maxNumRuns) {
        super(id, runsSinceInspection, passengers);
        this.rate = rate;
        this.photoFees = photoFees;
        this.maxNumRuns = maxNumRuns;
    }
    /**
     * A RollerCoaster object contructor that defaults passengers to an empty array with a length of 4,
     * rate to 10, and photo fees to 15.
     * @param id String representing the identifier for the ride
     * @param runsSinceInspection int representing the number of times the ride has run since the last inspection
     * @param maxNumRuns int representing the total number of times that ride can run
     */
    public RollerCoaster(String id, int runsSinceInspection, int maxNumRuns) {
        this(id, runsSinceInspection, new String[4], 10, 15, maxNumRuns);
    }
    /**
     * A RollerCoaster object contructor that defaults passengers to an empty array with a length of 4,
     * rate to 10, photo fees to 15, runsSinceInspection to 0, and maxNumRuns to 200.
     * @param id String representing the identifier for the ride
     */
    public RollerCoaster(String id) {
        this(id, 0, new String[4], 10, 15, 200);
    }
    @Override
    public boolean canRun(int numRuns) {
        if (numRuns < 0) {
            return false;
        }
        int totalRuns = runsSinceInspection + numRuns;
        return totalRuns <= maxNumRuns;
    }
    @Override
    public boolean inspectRide(String[] rideComponents) {
        int x = 0;
        for (String str : rideComponents) {
            if (str.toLowerCase().equals("tracks clear") || str.toLowerCase().equals("brakes ok")) {
                x++;
            }
        }
        if (x >= 2) {
            this.runsSinceInspection = 0;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public double costPerPassenger(int numStops) {
        return numStops * rate + photoFees;
    }
    @Override
    public  boolean addPassengers(int numStops, String[] passengerNames) {
        if (canRun(numStops) && willFit(passengerNames)) {
            for (int i = 0; i < passengerNames.length;) {
                for (int x = 0; x < passengers.length; x++) {
                    if (i >= passengerNames.length) {
                        continue;
                    }
                    if (passengers[x] == null) {
                        passengers[x] = passengerNames[i];
                        chargePassenger(numStops);
                        i++;
                    }
                }
            }
            runsSinceInspection += numStops;
            return true;
        } else {
            return false;
        }
    }
    /**
     * Tells the user whether or not the group fits on the ride.
     * @param passengerNames names of the passengers being added to the ride
     * @return boolean that represents whether or not the group fits on the ride
     */
    private boolean willFit(String[] passengerNames) {
        int nullnum = 0;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                nullnum++;
            }
        }
        return nullnum >= passengerNames.length;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof RollerCoaster) {
            RollerCoaster newobj = (RollerCoaster) obj;
            if (newobj.id.equals(this.id) && newobj.runsSinceInspection == this.runsSinceInspection && newobj.rate
                == this.rate && newobj.photoFees == this.photoFees && newobj.maxNumRuns == this.maxNumRuns) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("Roller Coaster %s has run %d times and has earned $%.2f. It can only run %d more times."
        + " It costs $%.2f per ride and there is a one-time photo fee of $%.2f.",
        this.id, this.runsSinceInspection, this.earnings, this.maxNumRuns - this.runsSinceInspection,
        this.rate, this.photoFees);
    }
}