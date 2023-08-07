import java.util.Scanner;
public class Game {
    public static void new_game() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Créez le plateau \n, quel nom lui donnez vous ? \n nom du plateau : ");
        String name = keyboard.nextLine();
        System.out.println("Choisissez la taille du plateau : ");
        int length = keyboard.nextInt();
        Maps map = new Maps(name, length);
        int map_length = map.getLength();
        System.out.println("Description de la carte : \n nom: " + map.getName() + "Taille : " + map.getLength());
        playground(map_length);
    }

    public static void playground(int map_length) {
        Scanner keyboard = new Scanner(System.in);
        int player_position = 1; // Le joueur débute à la première case
        System.out.println("Que voulez-vous faire ? \n 1 : Lancer un dés de déplacement \n 0 : Quitter le jeu");

        switch (keyboard.nextInt()) {
            case 0:
                System.out.println("Merci d'avoir joué");
                System.exit(0);
                break;
            case 1:
                playground_limit(map_length, moving(player_position));
                // le  player_position doit s'incrémenter
                playground(map_length);
                break;


        }

    }

    public static int moving(int player_position) {

        int dice = (int) (Math.random() * 5) + 1; // Dé entre avec nombre compris entre 1 et 6.
        System.out.println("Lancement du dé de déplacement \n Résultat du dé : " + dice);
        player_position += dice;

        System.out.println("La position du personnage est la case " + player_position);
        return player_position;
    }

    public static void playground_limit(int playground_length,int player_position) {

        if (player_position >= playground_length) {
            player_position = playground_length;
            System.out.println("Le personnage est arrivé au bout du plateau à la case " + player_position);
        }
    }
}
