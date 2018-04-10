package ee.ttu.markmik.notes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {

    private NotesService noteService;

    public NotesController(NotesService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value="/notes/add", method= RequestMethod.POST,
            consumes = "application/json")
    public Notes addNotes(@RequestBody Notes note) {
        return noteService.addNote(note);
    }

    @RequestMapping(value="/note", method=RequestMethod.GET)
    public List<Notes> getAllNotes() {
        return noteService.getAllNotes();
    }

    @RequestMapping(value = "/notes/{id}", method=RequestMethod.GET)
    public Notes getNote(@PathVariable("userId") long userId) {
        return noteService.getNotesById(userId);
    }
    
    @DeleteMapping(value = "/notes/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long idx) {

        noteService.deleteNoteById(idx);
        
    }

}


