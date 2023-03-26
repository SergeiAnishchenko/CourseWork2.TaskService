import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IncorrectArgumentException, ParseException, TaskNotFoundException {

        OneTimeTask oneTimeTask1 = new OneTimeTask("Разовая задача.", Type.WORK, LocalDateTime.of(2023, 3, 20, 15, 0), "Отправить письмо контрагенту.");
        OneTimeTask oneTimeTask2 = new OneTimeTask("Разовая задача.", Type.PERSONAL, LocalDateTime.of(2023, 3, 27, 17, 0), "Сходить на родительское собрание.");
        DailyTask dailyTask1 = new DailyTask("Ежедневная задача.", Type.WORK, LocalDateTime.of(2023, 3, 20, 10, 0), "Проверить почту.");
        DailyTask dailyTask2 = new DailyTask("Ежедневная задача.", Type.PERSONAL, LocalDateTime.of(2023, 3, 27, 5, 50), "Проснуться.");
        WeeklyTask weeklyTask1 = new WeeklyTask("Еженедельная задача", Type.WORK, LocalDateTime.of(2023, 3, 20, 15, 20), "Прийти на планерку.");
        WeeklyTask weeklyTask2 = new WeeklyTask("Еженедельная задача", Type.PERSONAL, LocalDateTime.of(2023, 3, 27, 9, 0), "Спорт.");
        MonthlyTask monthlyTask1 = new MonthlyTask("Ежемесячная задача", Type.WORK, LocalDateTime.of(2023, 3, 20, 10, 0), "Оплатить услуги контрагента.");
        MonthlyTask monthlyTask2 = new MonthlyTask("Ежемесячная задача", Type.PERSONAL, LocalDateTime.of(2023, 3, 27, 10, 0), "Заплатить за КУ.");
        YearlyTask yearlyTask1 = new YearlyTask("Ежегодная задача", Type.WORK, LocalDateTime.of(2023, 03, 20, 23, 59), "Сдать годовой отчет.");
        YearlyTask yearlyTask2 = new YearlyTask("Ежегодная задача", Type.PERSONAL, LocalDateTime.of(2023, 06, 27, 10, 30), "Праздновать День Рождения.");

        TaskService taskService = new TaskService();
        taskService.add(oneTimeTask1);
        taskService.add(oneTimeTask2);
        taskService.add(dailyTask1);
        taskService.add(dailyTask2);
        taskService.add(weeklyTask1);
        taskService.add(weeklyTask2);
        taskService.add(monthlyTask1);
        taskService.add(monthlyTask2);
        taskService.add(yearlyTask1);
        taskService.add(yearlyTask2);


        System.out.println("Список задач на первую дату.");
        LocalDate dateToBeChecked = LocalDate.of(2029, 3, 20);
        taskService.getAllByDate(dateToBeChecked).forEach(System.out::println);
        System.out.println();


        System.out.println("Список задач на вторую дату.");
        LocalDate dateToBeChecked2 = LocalDate.of(2029, 3, 21);
        taskService.getAllByDate(dateToBeChecked2).forEach(System.out::println);
        System.out.println();


        taskService.remove(1);
        taskService.remove(3);
        taskService.remove(5);
        taskService.remove(7);
        taskService.remove(9);


        System.out.println("Список удаленных задач.");
        taskService.getRemovedTasks();
        System.out.println();


        System.out.println("Вывожу в консоль одну из задач по id.");
        System.out.println(taskService.getTaskMap().get(2));
        System.out.println();


        taskService.updateTitle(2, "НОВАЯ Разовая задача");
        taskService.updateDescription(2,"ПРОГУЛЯТЬ родительское собрание!");
        System.out.println("Вывожу в консоль задачу с тем же id с новым заголовком и описанием.");
        System.out.println(taskService.getTaskMap().get(2));



//        Scanner scan = new Scanner("OneTimeTask oneTimeTask1 = new OneTimeTask(\"Разовая задача.\", Type.WORK, LocalDateTime.of(2023, 3, 20, 15, 0), \"Отправить письмо контрагенту.\");\n" +
//                "OneTimeTask oneTimeTask2 = new OneTimeTask(\"Разовая задача.\", Type.PERSONAL, LocalDateTime.of(2023, 3, 24, 17, 0), \"Сходить на родительское собрание.\");\n" +
//                "DailyTask dailyTask1 = new DailyTask(\"Ежедневная задача.\", Type.WORK, LocalDateTime.of(2023, 3, 23, 10, 0), \"Проверить почту.\");\n" +
//                "DailyTask dailyTask2 = new DailyTask(\"Ежедневная задача.\", Type.PERSONAL, LocalDateTime.of(2023, 3, 23, 5, 50), \"Проснуться.\");\n" +
//                "WeeklyTask weeklyTask1 = new WeeklyTask(\"Еженедельная задача\", Type.WORK, LocalDateTime.of(2023, 3, 20, 15, 20), \"Прийти на планерку.\");\n" +
//                "WeeklyTask weeklyTask2 = new WeeklyTask(\"Еженедельная задача\", Type.PERSONAL, LocalDateTime.of(2023, 3, 18, 9, 0), \"Спорт.\");\n" +
//                "MonthlyTask monthlyTask1 = new MonthlyTask(\"Ежемесячная задача\", Type.WORK, LocalDateTime.of(2023, 3, 21, 10, 0), \"Оплатить услуги контрагента.\");\n" +
//                "MonthlyTask monthlyTask2 = new MonthlyTask(\"Ежемесячная задача\", Type.PERSONAL, LocalDateTime.of(2023, 3, 21, 10, 0), \"Заплатить за КУ.\");\n" +
//                "YearlyTask yearlyTask1 = new YearlyTask(\"Ежегодная задача\", Type.WORK, LocalDateTime.of(2023, 03, 25, 23, 59), \"Сдать годовой отчет.\");\n" +
//                "YearlyTask yearlyTask2 = new YearlyTask(\"Ежегодная задача\", Type.PERSONAL, LocalDateTime.of(2023, 06, 27, 10, 30), \"Праздновать День Рождения.\");\n");
//
//        scan.useDelimiter("\n");
//        while (scan.hasNext()) {
//            System.out.println(scan.next() + "");
//        }
//
//        scan.close();
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.println("Введите заголовок задачи.");
//        if (scanner.hasNextLine()) {
//            String title = scanner.next();
//            System.out.println("Заголовок задачи:" + title);
//        } else {
//            System.out.println("Введены некорректные данные. Введите текст для заголовка задачи.");
//        }
//
//
//        System.out.println("Введите тип задачи, выбрав из двух вариантов: WORK или PERSONAL");
//        if (scanner.hasNextLine() && (Objects.equals(scanner.next(), "WORK") || Objects.equals(scanner.next(), "PERSONAL"))) {
//            String type = scanner.next();
//            System.out.println("Заголовок задачи:" + type);
//        } else {
//            System.out.println("Введены некорректные данные. Введите текст из двух вариантов (WORK или PERSONAL) для заголовка задачи.");
//        }
//
//
//        System.out.println("Введите дату и время создания задачи.");
//        if (scanner.hasNextLine()) {
//            String dateString = scanner.next();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            TemporalAccessor dateTime = formatter.parse(dateString);
//            System.out.println("Дата и время задачи:" + dateTime);
//        } else {
//            System.out.println("Дата и время введены некорректно.");
//        }
//
//
//        System.out.println("Введите описание задачи.");
//        if (scanner.hasNextLine()) {
//            String description = scanner.next();
//            System.out.println("Описание задачи:" + description);
//        } else {
//            System.out.println("Введены некорректные данные. Введите текст для описания задачи.");
//        }
//
//        scanner.close();

    }

}
