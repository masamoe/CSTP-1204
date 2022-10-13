import java.util.*;

public class Map {
    public static void main(String[] args) {
        HashMap<String, Integer> myFirstMap = new HashMap<String, Integer>();
        myFirstMap.put("one", 1);
        myFirstMap.put("two", 2);
        myFirstMap.put("three", 3);
        myFirstMap.remove("one");
        System.out.println(myFirstMap.size()); // 2
        System.out.println(myFirstMap.get("two")); // 2
        System.out.println(myFirstMap.containsKey("two")); // true
        System.out.println(myFirstMap.containsValue(2)); // true
        System.out.println(myFirstMap.isEmpty()); // false
        System.out.println(myFirstMap.keySet()); // [two, three]
        for (String key : myFirstMap.keySet()) {
            System.out.println(key + " " + myFirstMap.get(key));
        }
        for (HashMap.Entry<String, Integer> entry : myFirstMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
