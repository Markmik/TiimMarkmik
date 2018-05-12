package ee.ttu.markmik.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/users/add", method= RequestMethod.POST,
            consumes = "application/json")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/users", method=RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable("id") long userId) {
        return userService.getUserById(userId);
    }
    
    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long idx) {

        userService.deleteUserById(idx);
        
    }
    
    @RequestMapping(value = "/users/search/{searchStr}", method=RequestMethod.GET)
	public List<User> searchUsers(@PathVariable("searchStr") String searchStr) {
    	
    	
		return userService.searchUsersByUsername(searchStr);
	}
    
}


