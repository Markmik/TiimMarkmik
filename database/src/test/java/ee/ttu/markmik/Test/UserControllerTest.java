package ee.ttu.markmik.Test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ee.ttu.markmik.user.User;
import ee.ttu.markmik.user.UserController;
import ee.ttu.markmik.user.UserService;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @InjectMocks
    private UserController userController;
    private User user1;
    private User user2;
    private List<User> users;
    @Before
    public void setup() {
        user1 = new User();user1.setUserid((long) 1);user1.setUsername("Username");user1.setPassword("Password");user1.setEmail("Email");
        
        user2 = new User();user2.setUserid((long) 2);user2.setUsername("Username2");user2.setPassword("Password2");user2.setEmail("Email2");

        users = new ArrayList<>();users.add(user1);users.add(user2);

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getAllUsers() throws Exception {
        
    	Mockito.when(userService.getAllUsers()).thenReturn(users);
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].userid", Matchers.is(1)))
                .andExpect(jsonPath("$[0].username", Matchers.is("Username")))
                .andExpect(jsonPath("$[0].password", Matchers.is("Password")))
                .andExpect(jsonPath("$[0].email", Matchers.is("Email")))
                .andExpect(jsonPath("$[1].userid", Matchers.is(2)))
                .andExpect(jsonPath("$[1].username", Matchers.is("Username2")))
                .andExpect(jsonPath("$[1].password", Matchers.is("Password2")))
                .andExpect(jsonPath("$[1].email", Matchers.is("Email2")));
        verify(userService, times(1)).getAllUsers();
        verifyNoMoreInteractions(userService);
        
        Assert.assertEquals(userService.getAllUsers(), users);
    }
    
    
    @Test
    public void getUser() throws Exception {
    	Mockito.when(userService.getUserById(1)).thenReturn(user1);
        
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userid", Matchers.is(1)))
                .andExpect(jsonPath("$.username", Matchers.is("Username")))
                .andExpect(jsonPath("$.password", Matchers.is("Password")))
                .andExpect(jsonPath("$.email", Matchers.is("Email")));
                
        verify(userService, times(1)).getUserById(1);
        verifyNoMoreInteractions(userService);
        
        Assert.assertEquals(userService.getUserById(1), user1);
    }

    
}
