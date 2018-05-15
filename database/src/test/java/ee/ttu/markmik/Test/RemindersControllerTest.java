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

import ee.ttu.markmik.reminders.Reminders;
import ee.ttu.markmik.reminders.RemindersController;
import ee.ttu.markmik.reminders.RemindersService;
import ee.ttu.markmik.user.User;
import ee.ttu.markmik.user.UserController;
import ee.ttu.markmik.user.UserService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class RemindersControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private RemindersService remindersService;
    @InjectMocks
    private RemindersController remindersController;
    private Reminders reminder1;
    private Reminders reminder2;
    private List<Reminders> reminders;
    private List<Reminders> remindersUser;
    @Before
    public void setup() {
    	
    	
    	reminder1 = new Reminders();reminder1.setId((long) 1);reminder1.setTitle("Title");reminder1.setText("Text");reminder1.setUsercode((long) 1);
        
    	reminder2 = new Reminders();reminder2.setId((long) 2);reminder2.setTitle("Title2");reminder2.setText("Text2");reminder1.setUsercode((long) 1);

        reminders = new ArrayList<>();reminders.add(reminder1);reminders.add(reminder2);
       

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(remindersController).build();
    }

    @Test
    public void getAllUsers() throws Exception {
        
    	Mockito.when(remindersService.getAllReminders()).thenReturn(reminders);
        mockMvc.perform(get("/reminders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$[0].title", Matchers.is("Title")))
                .andExpect(jsonPath("$[0].text", Matchers.is("Text")))
                .andExpect(jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(jsonPath("$[1].title", Matchers.is("Title2")))
                .andExpect(jsonPath("$[1].text", Matchers.is("Text2")));
               
        verify(remindersService, times(1)).getAllReminders();
        verifyNoMoreInteractions(remindersService);
        
        Assert.assertEquals(remindersService.getAllReminders(), reminders);
    }
    
    
    @Test
    public void getReminders() throws Exception {
    	Mockito.when(remindersService.searchRemindersByUsercode(1)).thenReturn(reminders);
        
    	mockMvc.perform(get("/reminders/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", Matchers.is(1)))
        .andExpect(jsonPath("$[0].title", Matchers.is("Title")))
        .andExpect(jsonPath("$[0].text", Matchers.is("Text")));
                
        verify(remindersService, times(1)).searchRemindersByUsercode(1);
        verifyNoMoreInteractions(remindersService);
        
        Assert.assertEquals(remindersService.searchRemindersByUsercode(1), reminders);
    }

    
}

