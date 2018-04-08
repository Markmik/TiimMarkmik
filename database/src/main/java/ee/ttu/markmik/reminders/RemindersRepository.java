package ee.ttu.markmik.reminders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemindersRepository extends CrudRepository<Reminders, Long> {
    @Override
    public List<Reminders> findAll();
}
