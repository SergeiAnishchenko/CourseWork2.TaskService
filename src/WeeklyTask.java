import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateToBeChecked) {
        return (dateToBeChecked.isEqual(getDateTime().toLocalDate()) ||
                dateToBeChecked.isAfter(getDateTime().toLocalDate()) && dateToBeChecked.getDayOfWeek() == getDateTime().getDayOfWeek());
    }

    @Override
    public String toString() {
        return "WeeklyTask: " + super.toString();
    }

}
