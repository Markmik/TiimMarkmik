package ee.ttu.markmik.reminders;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ee.ttu.markmik.notes.Notes;

import java.sql.Date;
import java.util.List;

@Repository
public interface RemindersRepository extends CrudRepository<Reminders, Long> {
    @Override
    public List<Reminders> findAll();
    
    @Query("SELECT U FROM Reminders U"
			+ " WHERE U.usercode=:usercode"
			+ " AND U.alarmDate>=CURDATE()"
			+ " ORDER BY (U.id) DESC")
    public List<Reminders> findByUsercode(@Param("usercode") long usercode);
    
    @Query("SELECT U FROM Reminders U"
			+ " WHERE U.alarmDate<=CURDATE()"
    		+ " AND U.usercode=:usercode"
			+ " ORDER BY (alarmDate) DESC")
    public List<Reminders> findByDate(@Param("usercode") long usercode);

	public Reminders findByTitle(String title);
}
