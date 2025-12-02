package generic;

public class Main {
    static void main() {
        var users = new GenericList<Instructor>();
        users.add(new Instructor(10));
        Utils.printUsers(users);
    }
}
