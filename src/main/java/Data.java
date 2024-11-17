import java.util.*;
import java.util.stream.Collectors;

public class Data {
    private static int postIdCounter = 1; // Counter for unique post IDs.
    private static final Random random = new Random();

    // Generate fake users with filtering criteria
    public static List<User> generateFakeUsers(int numUsers, int minAge, int maxAge) {
        List<User> users = new ArrayList<>();
        String[] genders = {"Male", "Female", "Non-binary"};
        String[] locations = {"Africa", "Asia", "Australia", "Europe", "North America", "South America"};
        String[] workplaces = {"GameHive Studios", "PixelPerfect Interactive", "EpicQuest Games", 
                               "ShadowByte Productions", "CrystalForge Entertainment"};
        String[] names = {"Maya Carter", "Liam Turner", "Sophia Wang", "Ethan Kim", "Isabella Rivera", 
                          "Aiden Patel", "Chloe Nguyen", "Lucas Silva", "Emma Davis", "Benjamin Lopez"};

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

   // Generate fake posts with filtering by user attributes and content
public static List<Post> generateFakePosts(List<User> users, int maxNumberOfPosts, Map<String, String> criteria, Set<String> includeKeywords, Set<String> excludeKeywords) {
    List<Post> posts = new ArrayList<>();

    // Filter users based on criteria
    List<User> filteredUsers = users.stream().filter(user -> {
        boolean matches = true;
        if (criteria.containsKey("age")) {
            matches &= user.age >= Integer.parseInt(criteria.get("age"));
        }
        if (criteria.containsKey("gender")) {
            matches &= user.gender.equalsIgnoreCase(criteria.get("gender"));
        }
        if (criteria.containsKey("location")) {
            matches &= user.location.equalsIgnoreCase(criteria.get("location"));
        }
        return matches;
    }).collect(Collectors.toList());

    for (User user : filteredUsers) {
        int postCount = random.nextInt(maxNumberOfPosts) + 1; // Random number of posts per user.
        for (int i = 0; i < postCount; i++) {
            // Create random content with variation
            String[] randomPhrases = {"amazing post", "exciting news", "Java programming", "Kumo word cloud"};
            String content = randomPhrases[random.nextInt(randomPhrases.length)] + " by " + user.realName;

            // Ensure includeKeywords appear in content
            if (!includeKeywords.isEmpty()) {
                content += " " + includeKeywords.iterator().next(); // Add the first includeKeyword
            }

            // Include or exclude posts based on keywords
            boolean includePost = true;
            if (!includeKeywords.isEmpty()) {
                includePost = includeKeywords.stream().anyMatch(content::contains);
            }
            if (excludeKeywords.stream().anyMatch(content::contains)) {
                includePost = false;
            }

            if (includePost) {
                String timestamp = "2024-11-13 12:00:00"; // Simulated timestamp.
                Post post = new Post(postIdCounter++, content, user, timestamp);
                user.posts.add(post); // Associate post with the user.
                posts.add(post); // Add post to the global list.
            }
        }
    }

    System.out.println("Generated " + posts.size() + " filtered fake posts."); // Debug output
    return posts;
}


    // Generate word frequency dictionary with filters
    public static Map<String, Integer> generateWordFrequency(List<Post> posts, Set<String> includeKeywords, Set<String> excludeKeywords) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (Post post : posts) {
            // Include or exclude posts based on keywords
            boolean includePost = true;
            if (!includeKeywords.isEmpty()) {
                includePost = includeKeywords.stream().anyMatch(post.content::contains);
            }
            if (excludeKeywords.stream().anyMatch(post.content::contains)) {
                includePost = false;
            }

            if (includePost) {
                String[] words = post.content.split("\\s+"); // Split content into words
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Normalize word
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        System.out.println("Generated word frequency dictionary with filters.");
        return wordFrequency;
    }
}
