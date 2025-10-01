import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Lays out the list of medications for the user
 */
public class UserMeds implements RemindInter 
{
    private String name;
    private ArrayList<MedInfo> medications = new ArrayList<>();

    public UserMeds(String name) { this.name = name; }

    /** 
     * Returns the users name
     * @return the users name
     */

    public String getName() { return name; }

    /**
     *  Medication can be added to the user's list of medicines 
     * @param m for the medication to be added
     */

    public void addMed(MedInfo m) { medications.add(m); }

    /**
     * Will return a list of medicines that are due at their rightful timings
     * @param time for the present time
     * @return list of medicines which are due for their correct time
     */
    @Override
    public List<MedInfo> DueMeds(LocalTime time)
     {
        List<MedInfo> due = new ArrayList<>();

        for (MedInfo m : medications)
            if (m.isDoseDue(time)) due.add(m);
        return due;
    }
}
