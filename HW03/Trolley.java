/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Trolley extends Ride {
    /** An array of Strings that represents the stations a trolley goes to. */
    private String[] stations;
    /** An int that represents the index of the trolley's current station in stations array. */
    private int currentStation;
    /**
     * A Trolley object contructor that takes in id, runsSinceInspection,
     * stations, current stations, and sets passengers to be an empty array with a length of 20.
     * @param id identifier for ride.
     * @param runsSinceInspection number of times the ride has runs since last inspection.
     * @param stations the stations a trolley goes to.
     * @param currentStation index of the trolley's current station.
     */
    public Trolley(String id, int runsSinceInspection, String[] stations, int currentStation) {
        super(id, runsSinceInspection, new String[20]);
        this.stations = new String[stations.length];
        for (int i = 0; i < stations.length; i++) {
            this.stations[i] = stations[i];
        }
        this.currentStation = currentStation;
    }
    /**
     * A Trolley object contructor that takes in id, stations, current stations, sets runsSinceInspection to 0,
     * and sets passengers to be an empty array with a length of 20.
     * @param id identifier for ride.
     * @param stations the stations a trolley goes to.
     * @param currentStation index of the trolley's current station.
     */
    public Trolley(String id, String[] stations, int currentStation) {
        this(id, 0, stations, currentStation);
    }
    @Override
    public boolean canRun(int numRuns) {
        return numRuns >= 0;
    }
    @Override
    public boolean inspectRide(String[] rideComponents) {
        int x = 0;
        for (String str : rideComponents) {
            if (str.toLowerCase().equals("gas tank not empty") || str.toLowerCase().equals("tracks clear")) {
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
        return (double) (numStops * 3) / stations.length;
    }
    @Override
    public  boolean addPassengers(int numStops, String[] passengerNames) {
        if (canRun(numStops)) {
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
            moveTrolley(numStops);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Trolley) {
            Trolley newobj = (Trolley) obj;
            if (newobj.id.equals(this.id) && newobj.runsSinceInspection == this.runsSinceInspection
                && newobj.currentStation == this.currentStation) {
                for (int i = 0; i < this.stations.length; i++) {
                    if (!this.stations[i].equals(newobj.stations[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    /**
     * Method use to move the trolley a certain number of stops and set the currentStation accordingly.
     * @param numStations An int representing the number of stations the trolley needs to move.
     */
    public void moveTrolley(int numStations) {
        currentStation += numStations;
        if (currentStation >= stations.length) {
            runsSinceInspection += currentStation / stations.length;
            currentStation = currentStation % stations.length;
        }
    }
    /**
     * Method that tells the user what the next station is.
     * @return String representing the next station.
     */
    private String nextStation() {
        if (currentStation == stations.length - 1) {
            return stations[0];
        } else {
            return stations[currentStation + 1];
        }
    }
    @Override
    public String toString() {
        return String.format("Trolley %s has driven %d loops and has earned $%.2f."
        + " This trolley is at %s. Next up is %s.", this.id, this.runsSinceInspection,
        this.earnings, this.stations[currentStation], this.nextStation());
    }
}