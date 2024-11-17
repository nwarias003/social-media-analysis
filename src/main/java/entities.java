import java.util.ArrayList;
import java.util.List;

// User class
public class User {
    String userName;
    String realName;
    int age;
    String gender;
    String workplace;
    String location;
    List<Post> posts = new ArrayList<>();

    public User(String userName, String realName, int age, String gender, String workplace, String location) {
        this.userName = userName;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
        this.workplace = workplace;
        this.location = location;
    }
}

// Post class
public class Post {
    int uid;
    String content;
    User author;
    String timestamp;

    public Post(int uid, String content, User author, String timestamp) {
        this.uid = uid;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
    }
}
