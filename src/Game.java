import java.util.Scanner;
public class Game {
    public void new_game() {
        //int player_position = 1 ; // Le joueur débute à la première case
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Créez le plateau \n, quel nom lui donnez vous ? \n nom du plateau : ");
        String name = keyboard.nextLine();
        System.out.println("Choisissez la taille du plateau : ");
        int length = keyboard.nextInt();
        Maps map = new Maps(name, length);
        int map_length = map.getLength();
        System.out.println("Description de la carte : \n nom: " + map.getName() + "Taille : " + map.getLength());
        play(map_length);
    }

    public void play(int map_length) {
        int player_position = 1; // Le joueur débute à la première case
       // while (!playground_limit(map_length, player_position)) {
        while (player_position < map_length) {
            switch (player_input()) {
                case 0:
                    System.out.println("Merci d'avoir joué");
                    System.exit(0);
                    break;
                case 1:
                    try {
                        player_position = moving(player_position);
                    } catch (Character_out_of_playground e) {
//                    if (playground_limit(map_length, player_position)) {
//                        System.out.println("Bravo vous avez gagné la partie !");
//                        break;
                    }
            }
        }
        //}

    }

    public int moving(int player_position) {
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Lancement du dé de déplacement \n Résultat du dé : " + dice);
        player_position += dice;

        if (player_position < 64) {
            System.out.println("La position du personnage est la case " + player_position);
        }
        if (player_position > 64) {
            throw new Character_out_of_playground("Le joueur est sorti du plateau");
        }
        return player_position;
    }

    public boolean playground_limit(int playground_length,int player_position) {
        boolean playground_end = false;
        if (player_position >= playground_length) {
            player_position = playground_length;
            playground_end = true;
            System.out.println("Le personnage est arrivé au bout du plateau à la case " + player_position);
        }
        return playground_end;
    }

    public int player_input (){
        int player_input;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ? \n 1 : Lancer un dés de déplacement \n 0 : Quitter le jeu");
        player_input = keyboard.nextInt();
        return player_input;
    }
}
