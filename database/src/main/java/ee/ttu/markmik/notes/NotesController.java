package ee.ttu.markmik.notes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ee.ttu.markmik.user.User;

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

    @RequestMapping(value = "/note/{id}", method=RequestMethod.GET)
    public List<Notes> searchNotes(@PathVariable("id") long usercode) {
        return noteService.searchNotesByUsercode(usercode);
    }
    
    
    @DeleteMapping(value = "/notes/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteNote(@PathVariable("id") Long idx) {

        noteService.deleteNoteById(idx);
        
    }

}


