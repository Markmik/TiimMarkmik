package ee.ttu.markmik.notes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {
    @Override
    public List<Notes> findAll();
}
