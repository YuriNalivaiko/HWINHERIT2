import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {

    @Test
    public void testSearchMultipleTasksFound() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Write documentation"));
        todos.add(new SimpleTask(2, "Read a book"));
        todos.add(new SimpleTask(3, "Write tests"));

        Task[] result = todos.search("Write");

        Assertions.assertEquals(2, result.length);
        Assertions.assertArrayEquals(
                new Task[]{new SimpleTask(1, "Write documentation"), new SimpleTask(3, "Write tests")},
                result
        );
    }

    @Test
    public void testSearchSingleTaskFound() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Write documentation"));

        Task[] result = todos.search("Write");

        Assertions.assertEquals(1, result.length);
        Assertions.assertArrayEquals(
                new Task[]{new SimpleTask(1, "Write documentation")},
                result
        );
    }

    @Test
    public void testSearchNoTaskFound() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(1, "Write documentation"));

        Task[] result = todos.search("Read");

        Assertions.assertEquals(0, result.length);
    }
}