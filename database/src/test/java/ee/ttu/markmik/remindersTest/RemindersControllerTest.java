package ee.ttu.markmik.remindersTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ee.ttu.markmik.reminders.RemindersController;
import ee.ttu.markmik.reminders.RemindersService;
@RunWith(SpringRunner.class)
@WebMvcTest(value = RemindersController.class,secure = false)
public class RemindersControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RemindersService reminderService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
