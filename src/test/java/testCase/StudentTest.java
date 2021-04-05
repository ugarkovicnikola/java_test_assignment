package testCase;

import org.junit.Test;
import pageObject.StudentPage;
import setup.FunctionalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest extends FunctionalTest {

  @Test
  public void addNewStudent() {
    driver.get("http://localhost:3000/student");

    StudentPage studentPage = new StudentPage(driver);
    assertTrue(studentPage.isInitialized());

    int numberOfEntriesBefore = studentPage.getNumberOfEntries();
    studentPage.addStudent();
    int numberOfEntriesAfter = studentPage.getNumberOfEntries();

    assertEquals(numberOfEntriesBefore,numberOfEntriesAfter);
  }
}
