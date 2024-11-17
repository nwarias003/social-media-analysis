import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.CollisionMode;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WordCloudTest {
    public static void main(String[] args) throws IOException {
        // Define word frequencies
        List<WordFrequency> wordFrequencies = Arrays.asList(
            new WordFrequency("Java", 100),
            new WordFrequency("Kumo", 90),
            new WordFrequency("Test", 80),
            new WordFrequency("Word", 70),
            new WordFrequency("Cloud", 60),
            new WordFrequency("Programming", 50),
            new WordFrequency("Visualization", 40),
            new WordFrequency("Code", 35),
            new WordFrequency("Graphics", 30),
            new WordFrequency("API", 25),
            new WordFrequency("Library", 20),
            new WordFrequency("Maven", 18),
            new WordFrequency("Text", 15),
            new WordFrequency("Frequency", 12),
            new WordFrequency("Color", 10),
            new WordFrequency("Palette", 8),
            new WordFrequency("Circle", 5),
            new WordFrequency("Background", 3)
        );

        // Set the dimensions of the word cloud
        Dimension dimension = new Dimension(800, 800);

        // Create the WordCloud object with proper parameters
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);

        // Configure the word cloud
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(400));
        wordCloud.setColorPalette(new ColorPalette(Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.CYAN, Color.MAGENTA));
        wordCloud.setFontScalar(new LinearFontScalar(10, 50));

        // Build and save the word cloud
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("wordcloud_output.png");

        System.out.println("Word cloud generated: wordcloud_output.png");
    }
}
