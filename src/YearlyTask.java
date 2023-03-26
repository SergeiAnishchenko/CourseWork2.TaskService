import java.time.LocalDate;
import java.time.LocalDateTime;


public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateToBeChecked) {
        return (dateToBeChecked.isEqual(getDateTime().toLocalDate()) ||
                dateToBeChecked.isAfter(getDateTime().toLocalDate()) && dateToBeChecked.getDayOfYear() == getDateTime().getDayOfYear());
    }

    @Override
    public String toString() {
        return "YearlyTask: " + super.toString();
    }

}
