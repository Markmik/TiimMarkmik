package ee.ttu.markmik.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.ttu.markmik.user.User;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository noteRepository;

    public NotesService(NotesRepository userRepository) {
        this.noteRepository = userRepository;
    }

    public Notes addNote(Notes note) {
        return noteRepository.save(note);
    }

    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    List<Notes> searchNotesByUsercode(long usercode) {
        return noteRepository.findByUsercode(usercode);
    }
    
    public void deleteNoteById(long noteId) {
        noteRepository.delete(noteId);
    }

	
}
