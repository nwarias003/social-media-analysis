import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.CollisionMode;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.*; // For Map, HashSet, Arrays, etc.
import java.util.stream.Collectors;

public class Task_3 {
    public static void main(String[] args) throws IOException {
        // Define criteria for filtering users and posts.
        Map<String, String> userCriteria = new HashMap<>();
        userCriteria.put("age", "18");  // Only include users aged 18 or older
        userCriteria.put("gender", "Male");  // Only include male users
        userCriteria.put("location", "North America");  // Only include users in North America

        Set<String> includeKeywords = new HashSet<>(Arrays.asList("Java", "exciting", "Kumo")); // Keywords to include
        Set<String> excludeKeywords = new HashSet<>(Arrays.asList("exclude", "ignore")); // Keywords to exclude

        // Generate fake users and posts.
        java.util.List<User> users = Data.generateFakeUsers(10, 10, 65); // Generate 10 fake users
        java.util.List<Post> posts = Data.generateFakePosts(users, 5, userCriteria, includeKeywords, excludeKeywords); // Generate filtered posts

        // Debug: Print filtered posts
        System.out.println("Filtered Posts:");
        for (Post post : posts) {
            System.out.println("- " + post.content);
        }

        // Generate word frequency from filtered posts.
        Map<String, Integer> wordFrequencyMap = Data.generateWordFrequency(posts, includeKeywords, excludeKeywords);

        // Debug: Print word frequencies
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Convert word frequency map to list of WordFrequency objects.
        java.util.List<WordFrequency> wordFrequencies = wordFrequencyMap.entrySet()
                .stream()
                .map(entry -> new WordFrequency(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        // Configure and generate the word cloud.
        Dimension dimension = new Dimension(800, 800);
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(400)); // Circle background with radius 400
        wordCloud.setColorPalette(new ColorPalette(Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE));
        wordCloud.setFontScalar(new LinearFontScalar(10, 50)); // Font size scaling

        wordCloud.build(wordFrequencies); // Build the word cloud
        wordCloud.writeToFile("wordcloud_output.png"); // Save to a file

        System.out.println("Word cloud generated: wordcloud_output.png");
    }
}
