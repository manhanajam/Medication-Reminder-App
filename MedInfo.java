import java.time.LocalTime;

/**
 * Represents the users medication with dosage and timing details
 */
public class MedInfo implements Comparable<MedInfo> 
{
    private String name, amount;
    private int frequencyHours;
    private LocalTime nextDose;
    public int getFrequencyHours()
     {
    return frequencyHours;
}

    /**
     * Has custom dosage timings for the next time the user needs medicine
     * @param name
     * @param amount
     * @param frequencyHours
     * @param nextDoseTime
     */
    public MedInfo(String name, String amount, int frequencyHours, LocalTime nextDoseTime) 
    {
        this.name = name; this.amount = amount; this.frequencyHours = frequencyHours; this.nextDose = nextDoseTime;
    }

    /**
    * Creates the medication from starting now
    * @param name the users name
    * @param amount the dosage amount
    * @param frequencyHours the time the medicine needs to be taken again
    */
    public MedInfo(String name, String amount, int frequencyHours)
     {
        this(name, amount, frequencyHours, LocalTime.now());
    }

    public String getName() { return name; }
    public String getAmount() { return amount; }
    public LocalTime getNextDose() { return nextDose; }

    /**
     * Checks if the medicine dose is due at the current time
     * @param now for the present time
     * @return true when the dose for the medicine is true
     */
    public boolean isDoseDue(LocalTime now) { return !now.isBefore(nextDose); }

    /**
     * Allows the next dosage time to be updated by adding the frequency(Hrs)
     */
    public void NewNextDose() { nextDose = nextDose.plusHours(frequencyHours); }

    /**
     * Returns a string with the medication details
     * @return a string that is formatted to give a description of the medication 
     */
    @Override
    public String toString() 
    {
        return name + " Dose: (" + amount + ") every " + frequencyHours + "Hr, next Dose is: " + nextDose;
    }

    /**
     * Compares other objects to see if anything is equivalent to the medication due to the name of it
     * @param obj for object comparison
     * @return true for when any names which match
     */
    @Override
    public boolean equals(Object obj) 
    {
        return obj instanceof MedInfo && name.equalsIgnoreCase(((MedInfo) obj).name);
    }

    /**
     * Compares medicine based on the next time for a dose
     * @param other for the other MedInfo for object comparison
     * @return negative num if the dose is early, positive if its later and 0 for equal
     */
    @Override
    public int compareTo(MedInfo other) 
    {
        return nextDose.compareTo(other.nextDose);
    }
}
