package ee.ttu.markmik.reminders;
import ee.ttu.markmik.user.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Reminders {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String text;
    private Long user_id;
    private LocalDateTime alarmTime;
    

    @ManyToOne
	User user;
}
