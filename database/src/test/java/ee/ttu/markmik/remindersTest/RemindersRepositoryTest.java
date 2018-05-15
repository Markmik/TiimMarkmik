/*package ee.ttu.markmik.remindersTest;

import static org.junit.Assert.assertThat;

import org.junit.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import ee.ttu.markmik.reminders.*;

public class RemindersRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private RemindersRepository remindersRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given
	    Reminders asd = new Reminders("asd");
	    entityManager.persist(asd);
	    entityManager.flush();
	 
	    // when
	    Reminders found = remindersRepository.findByTitle(asd.getTitle());
	 
	    // then
	    assertThat(found.getTitle())
	      .isEqualTo(asd.getTitle());
	}

}
*/