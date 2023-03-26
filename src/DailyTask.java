import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateToBeChecked) {
        return (dateToBeChecked.isEqual(getDateTime().toLocalDate())
                || dateToBeChecked.isAfter(getDateTime().toLocalDate()));
    }

    @Override
    public String toString() {
        return "DailyTask: " + super.toString();
    }

}
