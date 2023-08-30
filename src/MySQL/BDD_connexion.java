package MySQL;

import characters.Warriors;
import characters.Wizards;
import characters.Characters;
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
    //Singleton pour permettre une seule instanciation de la connexion
    private static Connection connection = null;
    private BDD_connexion(){
    }
    public static Connection getConnection(){
        if (connection == null){
            connect_to_BDD();
        }
        return connection;
    }
    //Connexion à la BDD avec le properties et le fichier .env
    private static void connect_to_BDD (){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/.env"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String url = prop.getProperty("url");
        String username = prop.getProperty("login");
        String password = prop.getProperty("pass");
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Echec de la connexion : " + e.getMessage());
        }
    }
    //Pour fermer la connexion
    public static void close_connection(){
        if (connection != null) {
            try{
                connection.close();
                System.out.println("fermeture de la connexion");
            }
            catch (SQLException e) {
                System.out.println("Echec de la fermeture de la connexion");
            }
        }
    }
    //Afficher tous les personnages dans la bdd
    public static List<Characters> select_heroes(Connection connection){
        List<Characters> characters = new ArrayList<>();
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

                if (heroes_class.equals("Warrior")) {
                    characters.add(new Warriors(name, health, force_value, shields_potions));
                }
                else if (heroes_class.equals("Wizard")) {
                    characters.add(new Wizards(name, health, force_value, weapons_spells, shields_potions));
                }

            }
        }
        catch (SQLException e) {
            System.out.println("erreur SQL : " + e.getMessage());
        }
        return characters;
    }
}