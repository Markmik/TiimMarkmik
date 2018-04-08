package ee.ttu.markmik.notes;
import ee.ttu.markmik.user.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Notes {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String text;
    private Long user_id;
    

    @ManyToOne
	User user;
}
