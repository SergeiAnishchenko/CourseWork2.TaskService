import java.util.*;
import java.util.stream.Collectors;

public class Main2FunctionalProgramming {
    public static void main(String[] args) {

        String text = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст.");

        if (scanner.hasNext()) {
            text = scanner.nextLine();

            scanner.close();

            String[] wordsOfText = text.split(" ");
            List<String> wordsOfTextList = new ArrayList<>(Arrays.asList(wordsOfText));

            // Сортирую список, чтобы получить последовательность элементов без учета регистра букв,
            // то есть сортирую по алфавиту без учета регистра.
            List<String> sortedWordsOfTextList = wordsOfTextList.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());


            // Из отсортированного по алфавиту без учета регистра списка создаю LinkedHashMap,
            // в котором значения элементов - это количество повторов слов в тексте, при этом элементы по-прежнему расположены в алфавитном порядке.
            Map<String, Integer> mapWordsOfText = new LinkedHashMap<>(10);
            for (String element : sortedWordsOfTextList) {

                if (mapWordsOfText.containsKey(element)) {
                    mapWordsOfText.put(element, mapWordsOfText.get(element) + 1);
                } else {
                    mapWordsOfText.put(element, 1);
                }
            }

            // Продолжаю сортировку, чтобы отсортировать расположенные в алфавитном порядке слова теперь еще и по количеству повторов в тексте.
            // Так на выходе получаю список всех слов, в котором слова расположены в первую очередь по количеству повторов, во вторую очередь - по алфавиту без учета регистра.
            Map<String, Integer> sortedMap = mapWordsOfText.entrySet().stream()
                    .sorted(Comparator.comparingInt(e -> -e.getValue()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new
                    ));

            // Выбираю первые 10 слов в отстортированной мапе (они же самые часто встречаемые в алфавитном порядке без учета регистра).
            Map<String, Integer> first10sortedMap = sortedMap.entrySet().stream().limit(10).collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (a, b) -> {
                        throw new AssertionError();
                    },
                    LinkedHashMap::new
            ));

            System.out.println();
            System.out.println("Количество слов в тексте: " + mapWordsOfText.size());

            System.out.println();
            System.out.println("TOP 10: ");
            for (Map.Entry<String, Integer> element : first10sortedMap.entrySet()) {
                System.out.println(element.getValue() + " " + element.getKey());
            }

        }
    }
}


