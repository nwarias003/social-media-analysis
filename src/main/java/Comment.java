import java.util.*;

public class Comment {
   User user; 
   String content; 
   Date creationDate; 
   
   public Comment(User user, String content, Date creationDate) { 
   
      this.user = user; 
      this.content = content; 
      this.creationDate = creationDate; 
   } 
} 
