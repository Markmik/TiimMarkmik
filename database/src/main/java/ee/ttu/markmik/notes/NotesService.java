package ee.ttu.markmik.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository noteRepository;

    public NotesService(NotesRepository userRepository) {
        this.noteRepository = userRepository;
    }

    public Notes addNote(Notes user) {
        return noteRepository.save(user);
    }

    public List<Notes> getAllNotes() {
        return noteRepository.findAll();
    }

    public Notes getNotesById(long userId) {
        return noteRepository.findOne(userId);
    }
}
