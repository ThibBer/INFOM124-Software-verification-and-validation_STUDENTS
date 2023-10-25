
package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.*;

class AutoAssignerTest {
    private AutoAssigner autoAssigner;

    @BeforeEach
    private void init(){
        autoAssigner = new AutoAssigner();
    }

    // helper method to create a ZonedDateTime
    private ZonedDateTime date(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());
    }

    @Test
    void noWorkshop(){
        // Assign
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Name", "Email"));

        // Act
        AssignmentsLogger assignmentsLogger = autoAssigner.assign(students, new ArrayList<>());

        // Assert
        assertThat(assignmentsLogger.getAssignments()).isEmpty();
        assertThat(assignmentsLogger.getErrors()).isEmpty();
    }

    @Test
    void noStudent(){
        // Assign
        ArrayList<Workshop> workshops = new ArrayList<>();
        workshops.add(new Workshop(1, "Name", Map.of(
            date(2023, 10, 25, 15, 20), 1,
            date(2023, 11, 26, 16, 30), 2
        )));

        // Act
        AssignmentsLogger assignmentsLogger = autoAssigner.assign(new ArrayList<>(), workshops);

        // Assign
        assertThat(assignmentsLogger.getAssignments()).isEmpty();
        assertThat(assignmentsLogger.getErrors()).isEmpty();
    }

    @Test
    void enoughPlacesInWorkshopSameDate(){
        // Assign
        ArrayList<Workshop> workshops = new ArrayList<>();
        workshops.add(new Workshop(1, "Name", Map.of(
            date(2023, 10, 25, 15, 20), 5
        )));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Name", "Email"));
        students.add(new Student(2, "Name 2", "Email 2"));
        students.add(new Student(3, "Name 3", "Email 3"));

        // Act
        AssignmentsLogger assignmentsLogger = autoAssigner.assign(students, workshops);

        // Assign
        assertThat(assignmentsLogger.getAssignments()).hasSize(3);
        assertThat(assignmentsLogger.getErrors()).hasSize(0);
    }

    @Test
    void enoughPlacesInWorkshopDifferentDates(){
        // Assign
        ArrayList<Workshop> workshops = new ArrayList<>();
        workshops.add(new Workshop(1, "Name", Map.of(
            date(2023, 10, 25, 15, 20), 1,
            date(2023, 4, 14, 9, 5), 1,
            date(2023, 8, 10, 12, 10), 1
        )));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Name", "Email"));
        students.add(new Student(2, "Name 2", "Email 2"));
        students.add(new Student(3, "Name 3", "Email 3"));

        // Act
        AssignmentsLogger assignmentsLogger = autoAssigner.assign(students, workshops);

        // Assign
        assertThat(assignmentsLogger.getAssignments()).hasSize(3);
        assertThat(assignmentsLogger.getErrors()).hasSize(0);
    }

    @Test
    void notEnoughPlacesInWorkshop(){
        // Assign
        AutoAssigner autoAssigner = new AutoAssigner();
        ArrayList<Workshop> workshops = new ArrayList<>();
        workshops.add(new Workshop(1, "Name", Map.of(
            date(2023, 10, 25, 15, 20), 1
        )));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Name", "Email"));
        students.add(new Student(2, "Name 2", "Email 2"));
        students.add(new Student(3, "Name 3", "Email 3"));

        // Act
        AssignmentsLogger assignmentsLogger = autoAssigner.assign(students, workshops);

        // Assign
        assertThat(assignmentsLogger.getAssignments()).hasSize(1);
        assertThat(assignmentsLogger.getErrors()).hasSize(2);
    }
}