package ee.ttu.markmik.reminders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Reminders getRemindersById(long userId) {
        return reminderRepository.findOne(userId);
    }
}
