import org.jgrapht.graph.DefaultEdge; 
import org.jgrapht.graph.DirectedMultigraph; 
import org.jgrapht.io.ComponentNameProvider; 
import org.jgrapht.io.GraphMLExporter; 
import java.util.*; 
import java.util.stream.Collectors;
import java.io.FileWriter;

public class SocialMediaNetwork { 
   
   List<User> users = new ArrayList<>(); 
   
   public void addUser(User user) { 
   
      users.add(user); 
   } 

   public void addConnection(User fromUser, User toUser, String type) { 

      fromUser.connections.add(new Connection(toUser, type)); 
   } 

   public void addPost(User user, Post post) { 
   
      user.posts.add(post); 
   } 

   public void addComment(Post post, Comment comment) { 

      post.comments.add(comment); 
      comment.user.comments.add(comment); 
   } 

   public void addView(Post post, User user) { 

      post.viewers.add(user); 
      user.viewedPosts.add(post); 
   } // Other methods to analyze data and generate diagrams
   
   public DirectedMultigraph<Object, DefaultEdge> createGraph() { 
      
      DirectedMultigraph<Object, DefaultEdge> graph = new DirectedMultigraph<>(DefaultEdge.class); 
      
      // Add users and their posts as nodes 
      for (User user : users) { graph.addVertex(user); 
      
         for (Post post : user.posts) { 
            graph.addVertex(post); 
            graph.addEdge(user, post); // Authorship 
            
            // Add comments as edges 
            for (Comment comment : post.comments) { 
               graph.addEdge(comment.user, post); 
            } 
            
            // Add views as edges 
            for (User viewer : post.viewers) { 
               
               graph.addEdge(viewer, post); 
            } 
         } 
      } 
      return graph; 
   }
   public List<User> getUsersWithMostPosts(int limit) { 
   
      return users.stream() 
         .sorted((u1, u2) -> Integer.compare(u2.posts.size(), u1.posts.size())) 
         .limit(limit) 
         .collect(Collectors.toList()); 
      } // Other methods for different analyses... 
   public void exportGraphToGraphML(DirectedMultigraph<Object, DefaultEdge> graph, String filename) throws Exception { 
   
      ComponentNameProvider<Object> vertexIdProvider = new IntegerComponentNameProvider<>(); 
      ComponentNameProvider<Object> vertexLabelProvider = Object::toString; 
      GraphMLExporter<Object, DefaultEdge> exporter = new GraphMLExporter<>(vertexIdProvider, vertexLabelProvider, null, null); 
      exporter.exportGraph(graph, new FileWriter(filename));
   } 
} 
   
