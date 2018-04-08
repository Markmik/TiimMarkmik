package ee.ttu.markmik.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.ttu.markmik.notes.*;
import ee.ttu.markmik.reminders.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long user_id;
    private String eMail;
    private String username;
    private String password;
    
    @OneToMany(mappedBy="user_id", cascade=CascadeType.ALL)
	List<Notes> notes;
    
    @OneToMany(mappedBy="user_id", cascade=CascadeType.ALL)
	List<Reminders> reminders;
}
