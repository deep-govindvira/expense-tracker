import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
   public static void main(String[] args) {
      if(args.length > 0) {
         String jsonData = args[0];
         processJsonData(jsonData);
      }
      else {
         System.out.println("No JSON data received from PHP.");
      }
   }

   private static void processJsonData(String jsonData) {
      try {
         JSONObject jsonObject = new JSONObject(jsonData);
         String note = jsonObject.getString("note");
         int cost = jsonObject.getInt("cost");

         try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.sqlite")) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS history (id INTEGER PRIMARY KEY AUTOINCREMENT, note TEXT NOT NULL, cost INTEGER NOT NULL)";
            try(PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL)) {
               createTableStatement.executeUpdate();
            }
            catch(Exception e) {
               System.out.println(e);
            }

            String insertDataSQL = "INSERT INTO history (note, cost) VALUES (?, ?)";
            try(PreparedStatement insertDataStatement = connection.prepareStatement(insertDataSQL)) {
               insertDataStatement.setString(1, note);
               insertDataStatement.setInt(2, cost);
               int rowsAffected = insertDataStatement.executeUpdate();
            }
         }
         catch(SQLException e) {
            e.printStackTrace();
         }
      }
      catch(Exception e) {
         System.err.println("Error processing JSON data: " + e.getMessage());
      }
   }
}
