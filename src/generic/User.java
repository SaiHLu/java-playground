package generic;

public class User implements Comparable<User>{
    private int points;

    public User(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(User user) {
//        = => 0
//        < => -1
//        > => 1
        return points - user.points;
    }

    @Override
    public String toString() {
        return "Points=" + points;
    }
}
