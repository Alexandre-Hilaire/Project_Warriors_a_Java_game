import java.util.Scanner;

public class Menu {
    String name;
    int health = 0;
    int force = 0;
    public void menu() {
        Scanner keyboard = new Scanner(System.in);
        String key;
        System.out.println("Enter \"1\" Pour créer un personnage \"0\" pour quitter le jeu");
        key = keyboard.nextLine();
        switch (key) {
            case "1":
                System.out.println("Vous entrez dans le menu création de personnage");
                character_creation();
                break;
            case "0":
                System.out.println("Merci d'avoir joué au jeu");
                System.exit(0);
                break;
        }
        keyboard.close();
    }

    public void character_creation() {
        Scanner keyboard = new Scanner(System.in);
        String key;
        System.out.println("Choisissez la classe du personnage \n 1 Guerrier \n 2 Mage \n 3 pour revenir au menu principal \n 0 pour quitter le jeu");
        key = keyboard.nextLine();
        switch (key) {
            case "0":
                System.out.println("Merci d'avoir joué");
                System.exit(0);
                break;
            case "1":
                System.out.println("Vous avez choisi Guerrier");
                warrior_creation();
                break;
            case "2":
                System.out.println("Vous avez choisi Mage");
                wizards_creation();
                break;
            case "3":
                System.out.println("Retour au menu précédent");
                Menu menu = new Menu();
                menu.menu();
        }
        //keyboard.close();
        Menu menu = new Menu();
        menu.menu();
    }

    public Warriors warrior_creation() {
        Scanner keyboard = new Scanner(System.in);
        String weapon;
        String shield;

        System.out.println("Veuillez renseigner les caractéristiques du Guerrier");

        System.out.println("Entrez le nom du Guerrier");
        this.name = keyboard.nextLine();
        submenu_character_creation(name, health, force);
        do {
            System.out.println("Entrez la vie du Guerrier (entre 5 et 10)");
            health = keyboard.nextInt();
        } while (health < 5 || health > 10);
        submenu_character_creation(name, health, force);
        do {
            System.out.println("Entrez la force du Guerrier (entre 5 et 10)");
            force = keyboard.nextInt();
            keyboard.nextLine(); // Doublement, car il considère entrée comme une chaine vide du coup weapon serait " "
        } while (force < 5 || force > 10);
        submenu_character_creation(name, health, force);
        System.out.println("Entrez le nom de l'arme du Guerrier");
        weapon = keyboard.nextLine();
        System.out.println("Entrer le nom du bouclier du Guerrier");
        shield = keyboard.nextLine();

        Warriors new_warrior = new Warriors(name, health, force, weapon, shield);

        System.out.println("Voici les caractéristiques de votre nouveau Guerrier\n" + "Nom : " + new_warrior.getName() + "\n Santé "
                + new_warrior.getHealth() + "\n Force : " + new_warrior.getForce() + "\n Arme : " + new_warrior.getWeapon() + "\n Bouclier : " + new_warrior.getShield());
        return new_warrior;
    }

    public void wizards_creation() {
        Scanner keyboard = new Scanner(System.in);
        String spell;
        String potion;

        System.out.println("Veuillez renseigner les caractéristiques du Mage");

        System.out.println("Entrez le nom du Mage");
        name = keyboard.nextLine();
        do {
            System.out.println("Entrez la vie du Mage (entre 3 et 6)");
            health = keyboard.nextInt();
        } while (health < 3 || health > 6);
        do {
            System.out.println("Entrez la force du Mage (entre 8 et 15)");
            force = keyboard.nextInt();
            keyboard.nextLine(); // Le doublement comme dessus
        } while (force < 8 || force > 15);
        System.out.println("Entrez le nom du sort du Mage");
        spell = keyboard.nextLine();
        System.out.println("Entrez le nom de la potion du Mage");
        potion = keyboard.nextLine();

        Wizards new_wizard = new Wizards(name, health, force, spell, potion);

        System.out.println("Voici les caractéristiques de votre nouveau Guerrier\n" + "Nom : " + new_wizard.name + "\n Santé "
                + new_wizard.health + "\n Force : " + new_wizard.force + "\n Sort : " + new_wizard.spell + "\n Potion : " + new_wizard.potion);

    }
    public void submenu_character_creation (String name, int health, int force ) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ? \n Afficher les infos du personnage : 1 \n" +
                "Modifier les infos du personnage : 2 \n Poursuivre la création : 3");

        switch (keyboard.nextInt()) {
            case 1:
                System.out.println("Voici les caractéristiques du personnages \n" + "Nom " + name + "\n" + "Santé" + health + "\n" + "Force" + force);
                submenu_character_creation(name, health, force);
                break;
            case 2:
                update_character(name, health, force);

            case 3:
                System.out.println("Reprise de la création du personnage");
                break;
            }
        }
    public void update_character (String name, int health, int force) {
        Scanner keyboard = new Scanner(System.in);
        Warriors warrior = new Warriors();
        System.out.println("Modification du personnage");
        System.out.println("Ancien nom : " + name);
        System.out.println("Nouveau nom : ");
        name = keyboard.nextLine();
        System.out.println("ancienne santé : " + health);
        System.out.println("Nouvelle santé : ");
        health = keyboard.nextInt();
        System.out.println("Ancienne force : " + force);
        System.out.println("Nouvelle force : ");
        force = keyboard.nextInt();
        keyboard.nextLine(); // Ignorer la ligne vide après avoir lu l'entier

        // Appeler la fonction update_warrior avec les nouvelles valeurs
        warrior.update_warrior(name, health, force);

        System.out.println("Les informations du Guerrier ont été mises à jour :");
        System.out.println("Nom : " + warrior.getName());
        System.out.println("Santé : " + warrior.getHealth());
        System.out.println("Force : " + warrior.getForce());
    }
}


