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

import ee.ttu.markmik.notes.Notes;
import ee.ttu.markmik.notes.NotesController;
import ee.ttu.markmik.notes.NotesService;
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
public class NotesControllerTest {
    private MockMvc mockMvc;
    @MockBean
    private NotesService notesService;
    @InjectMocks
    private NotesController notesController;
    private Notes note1;
    private Notes note2;
    private List<Notes> notes;
    private List<Notes> notesUser;
    @Before
    public void setup() {
    	
    	
    	note1 = new Notes();note1.setId((long) 1);note1.setTitle("Title");note1.setText("Text");note1.setUsercode((long) 1);
        
    	note2 = new Notes();note2.setId((long) 2);note2.setTitle("Title2");note2.setText("Text2");note1.setUsercode((long) 1);

        notes = new ArrayList<>();notes.add(note1);notes.add(note2);
       

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(notesController).build();
    }

    @Test
    public void getAllUsers() throws Exception {
        
    	Mockito.when(notesService.getAllNotes()).thenReturn(notes);
        mockMvc.perform(get("/note"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$[0].title", Matchers.is("Title")))
                .andExpect(jsonPath("$[0].text", Matchers.is("Text")))
                .andExpect(jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(jsonPath("$[1].title", Matchers.is("Title2")))
                .andExpect(jsonPath("$[1].text", Matchers.is("Text2")));
               
        verify(notesService, times(1)).getAllNotes();
        verifyNoMoreInteractions(notesService);
        
        Assert.assertEquals(notesService.getAllNotes(), notes);
    }
    
    
    @Test
    public void getnotes() throws Exception {
    	Mockito.when(notesService.searchNotesByUsercode(1)).thenReturn(notes);
        
    	mockMvc.perform(get("/note/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id", Matchers.is(1)))
        .andExpect(jsonPath("$[0].title", Matchers.is("Title")))
        .andExpect(jsonPath("$[0].text", Matchers.is("Text")));
                
        verify(notesService, times(1)).searchNotesByUsercode(1);
        verifyNoMoreInteractions(notesService);
        
        Assert.assertEquals(notesService.searchNotesByUsercode(1), notes);
    }

    
}

