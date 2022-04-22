import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phonebook {

    private Map<String, HashSet<String>> map;
    Phonebook() {
        this.map = new HashMap<>();
    }

    void add (String Name, String phone) {
        HashSet<String> numbers;

        if (map.containsKey(Name)) {
            numbers = map.get(Name);
        } else {
            numbers = new HashSet<>();
        }
        numbers.add(phone);
        map.put(Name, numbers);

    }

    Set<String> get (String Name) {
        return map.get(Name);
    }
}
