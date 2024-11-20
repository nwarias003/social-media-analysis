import java.util.*; 

public class Connection {
   
   public User targetUser; 
   public String type; // "follows", "friends", "co-worker", "blocked", "has read posts by" 
   
   public Connection(User targetUser, String type) { 
   
      this.targetUser = targetUser; 
      this.type = type; 
   } 
} 
