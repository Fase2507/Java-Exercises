import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class Main {

    public static void main(String[] args) {
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("yas",50);

        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();

    }
}