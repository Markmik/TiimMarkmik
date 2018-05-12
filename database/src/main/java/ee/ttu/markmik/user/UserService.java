package ee.ttu.markmik.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long userId) {
        return userRepository.findOne(userId);
    }
    
    public void deleteUserById(long userId) {
        userRepository.delete(userId);
    }
    
    List<User> searchUsersByUsername(String email) {
		return userRepository.findByUsername(email);
	}
    
    

	
}
