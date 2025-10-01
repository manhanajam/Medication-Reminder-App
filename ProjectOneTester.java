import java.time.*;

/**
 * Project Name: Medication Reminder App
 * Name: Manha Najam
 * Student #: 501248364
 * Class: CPS209
 * Purpose: The aim of this project is to provide reminder to individuals to take their medication on time.
 * 
 * Classes:
 * - MedInfo: Contains the information of the medicine like the name, dosage amount, frequency and the time for next dose
 * - UserMeds: Contains info about the user and their medication 
 * - ElderlyMeds: Gives an extra reminder to the elderly user
 * - Reminders: Lays out the day for the user and their medication 
 * - RemindInter: Interface for medication reminder system
 * - ProjectOneTester: Runs the overall program
 */
public class ProjectOneTester 
{
    public static void main(String[] args) 
    {
        Reminders system = new Reminders();
        UserMeds user = new ElderlyMeds("Manha");

        /** List of a few types of medications e.g. Metformin is for diabetes and their info (e.g. dosage)*/ 
        user.addMed(new MedInfo("Tylenol", "250mg", 6, java.time.LocalTime.of(9, 0)));
        user.addMed(new MedInfo("Vitamin B12", "8IU", 24, java.time.LocalTime.of(18, 0)));
        user.addMed(new MedInfo("Vitamin C", "1000IU", 10, LocalTime.of(11, 0)));
        user.addMed(new MedInfo("Metformin", "500mg", 12, LocalTime.of(9, 0)));

        /** Adds the user to the reminder system and lays out the day for them from 1 AM to Midnight */
        system.addUser(user);
        system.Day(java.time.LocalTime.of(8, 0), java.time.LocalTime.of(20, 0));
    }
}
