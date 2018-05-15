package ee.ttu.markmik.notes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Long> {
    @Override
    public List<Notes> findAll();
    
    
    
    @Query("SELECT U FROM Notes U"
			+ " WHERE U.usercode=:usercode"
			+ " ORDER BY (U.id) DESC")
    public List<Notes> findByUsercode(@Param("usercode") long usercode);
}
