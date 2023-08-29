package MySQL;

import characters.Warriors;
import characters.Wizards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class BDD_connexion {
    public static Connection connexion_to_database() {
        String url = "jdbc:mysql://localhost:3306/heroes";
        String username = "player";
        String password = "player_password";
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
    public static void select_heroes(Connection connection){
        String query = "SELECT * FROM heroe";
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
                String shield = resultSet.getString("shield");
                System.out.println(id + " , class : " + heroes_class + ", Name : " + name + ", Health " + health + ", Force : " + force_value + ", " + weapons_spells + ", " + shield);
// partie de la fonction à mettre ailleurs dans le menu idéalement
//                if (heroes_class.equals("Warrior")) {
//                    Warriors new_warrior = new Warriors(name, health, force_value, shield);
//                }
//                else if (heroes_class.equals("Wizards")){
//                    Wizards new_wizard = new Wizards(name,health,force_value, weapons_spells);
//                }
//                System.out.println("Le personnage choisi est : \n " +
//                        heroes_class + "\n" +
//                        name + "\n" +
//                        health + "\n" +
//                        force_value + "\n"+
//                        weapons_spells + "\n" +
//                        shield);
            }
        }
        catch (SQLException e) {
            System.out.println("erreur SQL : " + e.getMessage());
        }
    }
}