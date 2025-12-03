package collection;

import java.util.HashMap;
import java.util.Map;

// Also known as HasTable, Dictionary, Object(javascript)
public class MapExample {
    public static void show() {
        Map<String, Customer> map = new HashMap<>();

        map.put("customer1", new Customer("customer1", "customer1"));
        map.put("customer2", new Customer("customer2", "customer2"));

        var cus1 = map.get("customer1");
        var cus1OrDefault = map.getOrDefault("customer not exist", new Customer("Unknown", "unknown"));

        System.out.println("Get value from map: " + cus1);
        System.out.println("Get value from map or default: " + cus1OrDefault);

        for(var customer: map.entrySet()) {
            System.out.println(customer);
        }

        System.out.println("Key exists: " + map.containsKey("hola"));
        System.out.println("Values only: " + map.values());
    }
}
