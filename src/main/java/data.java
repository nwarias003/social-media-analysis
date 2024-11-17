import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Data {
    private static int postIdCounter = 1; // Counter for unique post IDs.
    private static final Random random = new Random();

    public static List<User> generateFakeUsers(int numUsers, int minAge, int maxAge) {
    List<User> users = new ArrayList<>();
    String[] genders = {"Male", "Female", "Non-binary"};
    String[] locations = {"Africa", "Asia", "Australia", "Europe", "North America", "South America"};
    String[] workplaces = {"GameHive Studios", "PixelPerfect Interactive", "EpicQuest Games", "ShadowByte Productions", "CrystalForge Entertainment"};
    String[] names = {"Maya Carter", "Liam Turner", "Sophia Wang", "Ethan Kim", "Isabella Rivera", "Aiden Patel", "Chloe Nguyen", "Lucas Silva", "Emma Davis", "Benjamin Lopez"};

    for (int i = 0; i < numUsers; i++) {
        int age = random.nextInt(maxAge - minAge + 1) + minAge;
        String gender = genders[random.nextInt(genders.length)];
        String realName = names[random.nextInt(names.length)];
        String userName = realName.toLowerCase().replace(" ", "."); // Convert name to username
        String workplace = workplaces[random.nextInt(workplaces.length)];
        String location = locations[random.nextInt(locations.length)];

        User user = new User(userName, realName, age, gender, workplace, location);
        users.add(user);
    }

    System.out.println("Generated " + numUsers + " fake users.");
    return users;
}


    public static List<Post> generateFakePosts(List<User> users, int maxNumberOfPosts) {
        List<Post> posts = new ArrayList<>();
        for (User user : users) {
            int postCount = random.nextInt(maxNumberOfPosts) + 1; // Random number of posts per user.
            for (int i = 0; i < postCount; i++) {
                String content = "Sample post content by " + user.realName + " #" + (i + 1);
                String timestamp = "2024-11-13 12:00:00"; // Simulated timestamp.

                Post post = new Post(postIdCounter++, content, user, timestamp);
                user.posts.add(post); // Associate post with the user.
                posts.add(post); // Add post to the global list.
            }
        }

        System.out.println("Generated " + posts.size() + " fake posts.");
        return posts;
    }
}
