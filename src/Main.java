import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"sera", "phone", "comp", "tank", "pen", "sera", "phone", "mouse", "block", "phone"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);

        Set<String> unique = new HashSet<>(Arrays.asList(words));
        System.out.println(unique);

        Phonebook contact = new Phonebook();

        contact.add("Stefan", "+79145003511");
        contact.add("Sasha", "+79245312424");
        contact.add("Mama", "+79145147113");
        contact.add("Mama", "+79145147143");
        contact.add("Mama", "+79145147133");
        contact.add("Mama", "+79145147123");
        
        System.out.println(contact.get("Mama"));

    }
}
