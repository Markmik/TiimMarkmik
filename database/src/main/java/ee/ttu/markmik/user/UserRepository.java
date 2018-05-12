package ee.ttu.markmik.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    public List<User> findAll();
    
    public List<User> findByUsername(String email);
	
	
	
}

