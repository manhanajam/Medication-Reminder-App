import java.time.LocalTime;
import java.util.List;

/**
 * Interface for classes so that medication can be given in its respected time
 */
interface RemindInter {
    List<MedInfo> DueMeds(LocalTime time);
}
