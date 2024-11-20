import java.util.ArrayList;
import java.util.List;

public class User {
    public String userName;
    public String realName;
    public int age;
    public String gender;
    public String workplace;
    public String location;
    public List<Post> posts; // Declare posts field
    public List<Connection> connections; 
    public List<Post> postsAuthored; 
    public List<Post> postsRead; 
    public List<Comment> comments; 

    public User(String userName, String realName, int age, String gender, String workplace, String location) {
        this.userName = userName;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
        this.workplace = workplace;
        this.location = location;
        this.posts = new ArrayList<>(); // Initialize posts
        this.connections = new ArrayList<>(); 
        this.postsAuthored = new ArrayList<>(); 
        this.postsRead = new ArrayList<>(); 
        this.comments = new ArrayList<>(); 
    }
    @Override 
    public String toString() { 
        return username;
    }
}
