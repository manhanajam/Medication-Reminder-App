import java.time.LocalTime;
import java.util.List;


 /* The purpose of this is to give an elderly user an extra reminder for their medication
  * This class extends UserMeds and will override for elderly patients to recieve an extra reminder
 */
public class ElderlyMeds extends UserMeds 
{
    public ElderlyMeds(String name) { super(name); }

    /**
     * Returns list of medications which are due at the present time
     * Overrides so that there is a special reminder for elderly users
     * @param time the present time
     * @return is the list of medications which are due at the time
     */
    @Override
    public List<MedInfo> DueMeds(LocalTime time) {
        return super.DueMeds(time);  
    }
}
 