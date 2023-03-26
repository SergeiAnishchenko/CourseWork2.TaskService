import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateToBeChecked) {
        return (dateToBeChecked.isEqual(getDateTime().toLocalDate()) ||
                dateToBeChecked.isAfter(getDateTime().toLocalDate()) && dateToBeChecked.getDayOfMonth() == getDateTime().getDayOfMonth());
    }

    @Override
    public String toString() {
        return "MonthlyTask: " + super.toString();
    }

}
