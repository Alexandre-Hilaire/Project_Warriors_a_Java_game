import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class BDD_connexion {
    String url = "jdbc:mysql://localhost:3306/heroes";
    String username = "player";
    String password = "player_password";
    Connection connection = null;
    try {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connexion réussie !");
    }
    catch (SQLException e){
        System.out.println("Echec de la connexion : " + e.getMessage());
    }
}
