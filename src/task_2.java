import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Реализовать частотный словарь, выведите частоту повтора имен
public class task_2 {

    public static void main(String[] args) {
        String input = "Светлана Петрова,Кристина Белова,Анна Мусина,Анна Крутова,Иван Юрин,Петр Лыков,Павел Чернов,Петр Чернышов,Мария Федорова,Марина Светлова,Иван Савин,Мария Рыкова,Марина Лугова,Анна Владимирова,Иван Мечников,Петр Петин,Иван Ежов";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(input.split(",")));

        RepeaterCounter repeaterCounter = new RepeaterCounter();
        list.forEach(x -> repeaterCounter.put(x.toString().split(" ")[0], x));

        repeaterCounter.printRepeatInfo();

    }

    static class RepeaterCounter {
        private HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        public void put(String partToCount, String obj) {
            if (!this.hashMap.containsKey(partToCount)) this.hashMap.put(partToCount, new ArrayList<>());

            hashMap.get(partToCount).add(obj);
        }


        public void printRepeatInfo() {
            this.hashMap
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(el -> el.getKey(), el -> el.getValue().size()))
                    .entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);
        }
    }

}
