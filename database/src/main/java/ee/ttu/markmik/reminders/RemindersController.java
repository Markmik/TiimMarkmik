package ee.ttu.markmik.reminders;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemindersController {

    private RemindersService reminderService;

    public RemindersController(RemindersService reminderService) {
        this.reminderService = reminderService;
    }

    @RequestMapping(value="/reminders/add", method= RequestMethod.POST,
            consumes = "application/json")
    public Reminders addReminder(@RequestBody Reminders reminder) {
        return reminderService.addReminder(reminder);
    }

    @RequestMapping(value="/reminder", method=RequestMethod.GET)
    public List<Reminders> getAllReminders() {
        return reminderService.getAllReminders();
    }

    @RequestMapping(value = "/reminders/{id}", method=RequestMethod.GET)
    public Reminders getReminder(@PathVariable("userId") long userId) {
        return reminderService.getRemindersById(userId);
    }

}


