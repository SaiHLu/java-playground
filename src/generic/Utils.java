package generic;

/**
 * Java Generics Wildcards
 *
 * ?
 *   - Represents an unknown type.
 *
 * ? extends T
 *   - The type is T or any subtype of T (upper bounded wildcard).
 *   - Safe to read values as type T.
 *   - Not safe to write values (except null).
 *   - Useful when the method only needs to *consume* (read) items.
 *
 * ? super T
 *   - The type is T or any supertype of T (lower bounded wildcard).
 *   - Safe to write values of type T.
 *   - Reading returns Object (not T).
 *   - Useful when the method needs to *produce* (write) items.
 *
 * Summary:
 *   - "extends" = safe to read, not safe to write.
 *   - "super"   = safe to write, limited when reading.
 *   - Use "extends" when you want to take data out.
 *   - Use "super" when you want to put data in.
 */

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return first.compareTo(second) < 0 ? second: first;
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    public static void printUsers(GenericList<? extends User> users) {
        System.out.println(users);
    }
}
