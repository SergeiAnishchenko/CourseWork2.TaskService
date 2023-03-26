import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 0;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        setTitle(title);
        setDescription(description);
        this.type = type;
        this.dateTime = dateTime;
        this.id = ++idGenerator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title != null && !title.isEmpty() && !title.isBlank()) {
            this.title = title;

        } else {
            throw new IncorrectArgumentException("Заголовок задачи");
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description != null && !description.isEmpty() && !description.isBlank()) {
            this.description = description;
        } else {
            throw new IncorrectArgumentException("Описание задачи");
        }
    }

    public abstract boolean appearsln(LocalDate dateToBeChecked);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return this.title.equals(task.title) && this.type == task.type && this.id == task.id
                && this.dateTime.equals(task.dateTime) && this.description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return " Задача: " +
                " id: " + id +
                " Заголовок: " + title +
                " Тип: " + type +
                " Время: " + dateTime +
                " Описание: " + description;

    }
}
