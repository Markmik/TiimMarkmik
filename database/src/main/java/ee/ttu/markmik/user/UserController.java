package ee.ttu.markmik.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/user/add", method= RequestMethod.POST,
            consumes = "application/json")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable("id") long userId) {
        return userService.getUserById(userId);
    }

}


