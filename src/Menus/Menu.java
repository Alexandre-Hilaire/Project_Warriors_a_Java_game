package Menus;
import MySQL.BDD_connexion;
import java.sql.Connection;
import java.sql.SQLException;
import characters.Warriors;
import characters.Wizards;
import game.Game;
import items_skills.Spells;
import items_skills.Weapons;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    String name;
    int health = 0;
    int force = 0;
    public void menu() {
        Scanner keyboard = new Scanner(System.in);
        String key;
        System.out.println("Enter \"1\" Pour choisir ou créer un personnage, \"2\" pour commencer une partie \"0\" pour quitter le jeu");
        key = keyboard.nextLine();
        switch (key) {
            case "1":
                System.out.println("Vous entrez dans le menu choix du personnage");
                character_creation();
                break;
            case "2":
                System.out.println("Lancement de la partie");
                Game new_game = new Game();
                new_game.new_game();
            case "0":
                System.out.println("Merci d'avoir joué au jeu");
                System.exit(0);
                break;
        }
        keyboard.close();
    }

    //Liste des personnages
    List<Warriors> warriorsList = new ArrayList<>();
    List<Wizards> wizardsList = new ArrayList<>();
    public void character_creation (){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1 : Choisir un personnage déjà crée \n" +
                            "2 : Créer un nouveau personnage");
        switch (keyboard.nextInt()) {
            case 1 :
                Connection connection = BDD_connexion.getConnection();
                List<Character> characters = BDD_connexion.select_heroes(connection);
                for (Character character : characters){
                    System.out.println(character.toString());
                }
                Menu menu = new Menu();
                menu.menu();
                break;
            case 2 :
                new_character_creation();
                break;
        }
    }
    public void new_character_creation() {
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
                Warriors new_warrior = warrior_creation();
                warriorsList.add(new_warrior);
                displayWarriors();

                break;
            case "2":
                System.out.println("Vous avez choisi Mage");
                Wizards new_wizards = wizards_creation();
                wizardsList.add(new_wizards);
                displayWizards();
                break;
            case "3":
                System.out.println("Retour au menu précédent");
                Menu menu = new Menu();
                menu.menu();
        }
        Menu menu = new Menu();
        menu.menu();
    }


    public Warriors warrior_creation() {
        Scanner keyboard = new Scanner(System.in);
        String shield;
        String class_name = "Warrior";

        System.out.println("Veuillez renseigner les caractéristiques du Guerrier");

        System.out.println("Entrez le nom du Guerrier");
        this.name = keyboard.nextLine();
        do {
            System.out.println("Entrez la vie du Guerrier (entre 5 et 10)");
            health = keyboard.nextInt();
            keyboard.nextLine();
        } while (health < 5 || health > 10);
        do {
            System.out.println("Entrez la force du Guerrier (entre 5 et 10)");
            force = keyboard.nextInt();
            keyboard.nextLine(); // Doublement, car il considère entrée comme une chaine vide du coup weapon serait " "
        } while (force < 5 || force > 10);
        System.out.println("Entrez le nom de l'arme du Guerrier");
        String weapon_name = keyboard.nextLine();
        System.out.println("Entrez les dégats de l'arme");
        int weapon_damages = keyboard.nextInt();
        keyboard.nextLine();
        Weapons weapon = new Weapons(weapon_name, weapon_damages);
        System.out.println("Entrer le nom du bouclier du Guerrier");
        shield = keyboard.nextLine();

        characters.Warriors new_warrior = new characters.Warriors(name, health, force, shield);
        submenu_character_creation(name, health, force, class_name);
        System.out.println(new_warrior);
        return new_warrior;
    }

    public Wizards wizards_creation() {
        Scanner keyboard = new Scanner(System.in);
        String potion;
        String class_name = "Wizard";

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
        System.out.println("Entrez le nom du sort");
        String spell_name = keyboard.nextLine();
        System.out.println("Entrez les dégats du sort");
        int spell_damages = keyboard.nextInt();
        Spells new_spell = new Spells(spell_name, spell_damages);
        System.out.println("Entrez le nom de la potion du Mage");
        potion = keyboard.nextLine();

        Wizards new_wizard = new Wizards(name, health, force, potion);
        submenu_character_creation(name, health, force, class_name);
        System.out.println(new_wizard);
        return new_wizard;
    }
    public void displayWarriors() {
        System.out.println("Liste des guerriers :");
        for (Warriors warrior : warriorsList) {
            System.out.println(warrior);
        }
    }
    public void displayWizards() {
        System.out.println("Liste des mages :");
        for (Wizards wizard : wizardsList) {
            System.out.println(wizard);
        }
    }
    public void submenu_character_creation (String name, int health, int force, String class_name) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ? \n Afficher les infos du personnage : 1 \n" +
                "Modifier les infos du personnage : 2 \n Poursuivre la création : 3");

        switch (keyboard.nextInt()) {
            case 1:
                System.out.println("Voici les caractéristiques du personnages \n" + "Nom " + name + "\n" + "Santé" + health + "\n" + "Force" + force);
                submenu_character_creation(name, health, force, class_name);
                break;
            case 2:
                if (class_name.equals("Warrior")) {
                    update_warriors(name, health, force);
                }
                else if (class_name.equals("Wizard")){
                    update_wizards(name, health, force);
                }

            case 3:
                System.out.println("Reprise de la création du personnage");
                break;
            }
        }

    public void update_warriors (String name, int health, int force) {
        Scanner keyboard = new Scanner(System.in);
        Warriors warrior = new Warriors();
        System.out.println("Modification du personnage");
        System.out.println("Ancien nom : " + name);
        System.out.println("Nouveau nom : ");
        name = keyboard.nextLine();
        System.out.println("ancienne santé : " + health);
        do {
            System.out.println("Entrez la nouvelle santé du Guerrier (entre 5 et 10)");
            health = keyboard.nextInt();
        } while (health < 5 || health > 10);
        System.out.println("Ancienne force : " + force);
        do {
            System.out.println("Entrez la nouvelle force du Guerrier (entre 5 et 10)");
            force = keyboard.nextInt();
        } while (force < 5 || force > 10);
        keyboard.nextLine(); // Ignorer la ligne vide après avoir lu l'entier

        // Appeler la fonction update_warrior avec les nouvelles valeurs
        warrior.update_warrior(name, health, force);

        System.out.println("Les informations du Guerrier ont été mises à jour :");
        System.out.println("Nom : " + warrior.getName());
        System.out.println("Santé : " + warrior.getHealth());
        System.out.println("Force : " + warrior.getForce());
    }
    public void update_wizards (String name, int health, int force) {
        Scanner keyboard = new Scanner(System.in);
        Wizards wizards = new Wizards();
        System.out.println("Modification du personnage");
        System.out.println("Ancien nom : " + name);
        System.out.println("Nouveau nom : ");
        name = keyboard.nextLine();
        System.out.println("ancienne santé : " + health);
        do {
            System.out.println("Entrez la nouvelle santé du Mage (entre 5 et 10)");
            health = keyboard.nextInt();
        } while (health < 3 || health > 6);
        System.out.println("Ancienne force : " + force);
        do {
            System.out.println("Entrez la nouvelle force du Mage (entre 5 et 10)");
            force = keyboard.nextInt();
        } while (force < 8 || force > 15);
        keyboard.nextLine(); // Ignorer la ligne vide après avoir lu l'entier

        // Appeler la fonction update_warrior avec les nouvelles valeurs
        wizards.update_wizards(name, health, force);

        System.out.println("Les informations du Guerrier ont été mises à jour :");
        System.out.println("Nom : " + wizards.getName());
        System.out.println("Santé : " + wizards.getHealth());
        System.out.println("Force : " + wizards.getForce());
    }

}


