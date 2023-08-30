package MySQL;

import characters.Warriors;
import characters.Wizards;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;

public class BDD_connexion {
    public static Connection connexion_to_database() {

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/.env"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = prop.getProperty("url");
        String username = prop.getProperty("login");
        String password = prop.getProperty("pass");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Echec de la connexion : " + e.getMessage());
        }
        return connection;
        // bloc pour fermer la connexion
//        finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                    System.out.println("Connexion fermée");
//                }
//            } catch (SQLException e) {
//                System.out.println("Echec lors de la fermeture de la connexion : " + e.getMessage());
//            }
//        }
    }
    public static List<Character> select_heroes(Connection connection){
        List<Character> characters = new ArrayList<>();
        String query = "SELECT * FROM Player_heroes";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String heroes_class = resultSet.getString("class");
                String name = resultSet.getString("name");
                int health = resultSet.getInt("health");
                int force_value = resultSet.getInt("force_value");
                String weapons_spells = resultSet.getString("weapons_spells");
                String shields_potions = resultSet.getString("shields_potions");
                System.out.println(id + " , class : " + heroes_class + ", Name : " + name + ", Health " + health + ", Force : " + force_value + ", " + weapons_spells + ", " + shields_potions);
            }
        }
        catch (SQLException e) {
            System.out.println("erreur SQL : " + e.getMessage());
        }
        return characters;
    }
}