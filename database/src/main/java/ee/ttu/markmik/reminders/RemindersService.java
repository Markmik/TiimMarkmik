package ee.ttu.markmik.reminders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.markmik.notes.Notes;

import java.util.List;

@Service
public class RemindersService {

    @Autowired
    private RemindersRepository reminderRepository;

    public RemindersService(RemindersRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public Reminders addReminder(Reminders reminder) {
        return reminderRepository.save(reminder);
    }

    public List<Reminders> getAllReminders() {
        return reminderRepository.findAll();
    }

    List<Reminders> searchRemindersByUsercode(long usercode) {
        return reminderRepository.findByUsercode(usercode);
    }
    List<Reminders> searchByAlarmDate(long usercode) {
        return reminderRepository.findByDate(usercode);
    }
    
    public void deleteReminderById(long reminderId) {
        reminderRepository.delete(reminderId);
    }
}
