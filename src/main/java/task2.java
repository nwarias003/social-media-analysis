import java.util.*; 
import java.io.IOException;

public class task2 { 
   
   public static void main(String[] args) throws IOException{ 
      
      // Example usage: 
      SocialMediaNetwork network = new SocialMediaNetwork(); 
         
      // Add users, connections, posts, comments, and views 
      User user1 = new User("user1", "Alice", 30, "Female", "New York"); 
      User user2 = new User("user2", "Bob", 25, "Male", "Los Angeles"); 
         
      network.addUser(user1); 
      network.addUser(user2); 
         
      Post post1 = new Post("Hello world!", new Date()); 
      network.addPost(user1, post1); 
      
      Comment comment1 = new Comment(user2, "Nice post!", new Date()); 
      network.addComment(post1, comment1); 
      network.addView(post1, user2); 
      
      // Create graph
      DirectedMultigraph<Object, DefaultEdge> graph = network.createGraph();   
      
      // Analyze the data 
      List<User> topUsers = network.getUsersWithMostPosts(1); 
      
      // Export graph to GraphML 
      network.exportGraphToGraphML(graph, "social_media_graph.graphml");
         
      for (User user : topUsers) { 
            
         System.out.println("Top User: " + user.username); 
      } 
   } 
}

