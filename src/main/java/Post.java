public class Post {
    public int id;
    public String content;
    public User author;
    public String timestamp;

    public Post(int id, String content, User author, String timestamp) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
    }
}
