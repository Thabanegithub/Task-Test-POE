package accountcreation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TaskTest {
    

    @Test
    public void testCheckTaskDescription() {
        Task task = new Task("Login", 0, "Create login feature", "Mpho Thabane", 5, "To Do");
        assertTrue(task.checkTaskDescription());

        task = new Task("Login", 0, "This is a very long description that exceeds fifty characters", "Mpho Thabane", 5, "To Do");
        assertFalse(task.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Login", 0, "Create login feature", "Mpho Thabane", 5, "To Do");
        assertEquals("LO:0:ANE", task.createTaskID());
    }
    
    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        taskManager.addTask("Mike Smith", "Create Login", 5, "To Do");
        taskManager.addTask("Edward Harrison", "Create Add features", 8, "Doing");
        taskManager.addTask("Samantha Paulson", "Create Reports", 2, "Done");
        taskManager.addTask("Glenda Orbeholzer", "Add Arrays", 11, "To Do");
    }

    @Test
    void testDeveloperArrayPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Orbeholzer"};
        assertArrayEquals(expectedDevelopers, taskManager.getDevelopers());
    }

    @Test
    void testLongestDurationTask() {
        assertEquals("Glenda Orbeholzer, 11", taskManager.getLongestDurationTask());
    }

    @Test
    void testSearchTask() {
        assertEquals("Mike Smith, Create Login", taskManager.searchTask("Create Login"));
    }

    @Test
    void testSearchTasksByDeveloper() {
        assertEquals("Create Reports", taskManager.searchTasksByDeveloper("Samantha Paulson"));
    }

    @Test
    void testDeleteTask() {
        assertTrue(taskManager.deleteTask("Create Reports"));
        assertNull(taskManager.searchTask("Create Reports"));
    }

    @Test
    void testDisplayReport() {
        String expectedReport = 
            "Developer Mike Smith\n" +
            "Task Name: Create Login\n" +
            "Task Duration: 5 hours\n" +
            "Task Status: To Do\n\n" +
            "Developer Edward Harrison\n" +
            "Task Name: Create Add features\n" +
            "Task Duration: 8 hours\n" +
            "Task Status: Doing\n\n" +
            "Developer Samantha Paulson\n" +
            "Task Name: Create Reports\n" +
            "Task Duration: 2 hours\n" +
            "Task Status: Done\n\n" +
            "Developer Glenda Orbeholzer\n" +
            "Task Name: Add Arrays\n" +
            "Task Duration: 11 hours\n" +
            "Task Status: To Do\n";
        assertEquals(expectedReport, taskManager.displayReport());
    }
}

    // More tests for printTaskDetails, returnTotalHours
}

