import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateToBeChecked) {
        return (dateToBeChecked.isEqual(getDateTime().toLocalDate()));
    }

    @Override
    public String toString() {
        return "OneTimeTask: " + super.toString();
    }

}
