import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    private Map<Integer, Task> taskMap = new LinkedHashMap<>();
    private final List<Task> removedTasks = new LinkedList<>();

    public Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void remove(int id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Задача не найдена.");
        }
        removedTasks.add(taskMap.get(id));
        taskMap.remove(id);
    }

    public List<Task> getAllByDate(LocalDate dateToBeChecked) {
        List<Task> listOfTasksByDate = new LinkedList<>();
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            if (entry.getValue().appearsln(dateToBeChecked)) {
                listOfTasksByDate.add(entry.getValue());
            }
        }
        return listOfTasksByDate;
    }

    public void getRemovedTasks() {
        for (Task removedTask : removedTasks) {
            System.out.println(removedTask);
        }
    }

    public void updateTitle(int id, String newTitle) throws IncorrectArgumentException {
        taskMap.get(id).setTitle(newTitle);
    }

    public void updateDescription(int id, String newDescription) throws IncorrectArgumentException {
        taskMap.get(id).setDescription(newDescription);
    }

}



