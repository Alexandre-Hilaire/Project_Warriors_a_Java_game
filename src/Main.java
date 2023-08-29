public class Main {
    public static void main(String[] args){ //Début du programme

        BDD_connexion.connexion_to_database();
        Menu menu = new Menu(); // Création du menu
        menu.menu();
    }
}