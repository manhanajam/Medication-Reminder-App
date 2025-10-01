import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Lays out reminders and scheduling for the medication for all the users
 */
public class Reminders 
{
    private ArrayList<UserMeds> users = new ArrayList<>();

    /**
     * Adds user to the reminder system
     * @param u is the UserMeds object which showcases a user and the medications they use
     */
    public void addUser(UserMeds u) { users.add(u); }

    /**
     * Lays out the day and gives reminders from the start time to the end time
     * It will check every hour to see if there is a reminder for medication
     * Elderly users will get an additional reminder for their medication
     * @param start the start time
     * @param end the end time
     */
    public void Day(LocalTime start, LocalTime end) 
    {
        System.out.println("\n- Laying out The Day: " + start + " to " + end + " -\n");

        for (LocalTime time = start; !time.isAfter(end); time = time.plusHours(1)) 
        {
            boolean printedTime = false;

            for (UserMeds u : users) 
            {
                List<MedInfo> due = u.DueMeds(time);
                if (!due.isEmpty()) 
                {
                    if (!printedTime)
                     {
                        System.out.println("[" + time + "]");
                        printedTime = true;
                    }

                    if (u instanceof ElderlyMeds) 
                    {
                        System.out.println("A reminder for Elderly User: Please take meds on time, no skipping!");
                    }

                    for (MedInfo m : due)
                     {
                        System.out.println("Reminder: " + u.getName() + " Take the medicine " + m.getName() + " At this dosage (" + m.getAmount() + ")");
                        m.NewNextDose();
                    }
                }
            }

            if (printedTime) System.out.println();
        }
    } 
} 
