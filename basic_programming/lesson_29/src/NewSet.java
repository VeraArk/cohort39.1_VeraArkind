
import java.util.HashSet;
import java.util.Set;

// Напишите метод, который принимает два множества и возвращает новое множество, содержащее их пересечение. (Допустимо взять Set<String>)
//(Только те элементы, которые содяржаться в обоих Set)
    public class NewSet {
        public static void main(String[] args) {
            Set<String> nameForWomen = new HashSet<>();
            nameForWomen.add("Sascha");
            nameForWomen.add("Vera");
            nameForWomen.add("Sonja");
            nameForWomen.add("Valja");
            nameForWomen.add("Jenja");
            nameForWomen.add("Klara");

            Set<String> nameForMen = new HashSet<>();
            nameForMen.add("Sascha");
            nameForMen.add("Ivan");
            nameForMen.add("Petr");
            nameForMen.add("Valja");
            nameForMen.add("Jenja");
            nameForMen.add("Valera");

            Set<String> nameForWomenAndMen = intercectName(nameForWomen, nameForMen);
            System.out.println("Список имен, которые подходят и девочкам, и мальчикам, выглядят так: " + nameForWomenAndMen);
        }

        public static Set<String> intercectName(Set<String> forMen, Set<String> forWomen) {
            Set<String> tempo = new HashSet<>(forMen);
            tempo.retainAll(forWomen);
            return tempo;
        }
    }

