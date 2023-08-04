import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
public class Menu {
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

        keyboard.close();
    }

    public void warrior_creation() {
        Scanner keyboard = new Scanner(System.in);
        String name;
        int health = 0;
        int force = 0;
        String weapon;
        String shield;

        System.out.println("Veuillez renseigner les caractéristiques du Guerrier");

        System.out.println("Entrez le nom du Guerrier");
        name = keyboard.nextLine();
        submenu_character_creation(name, health, force);
        do {
            System.out.println("Entrez la vie du Guerrier (entre 5 et 10)");
            health = keyboard.nextInt();
        } while (health < 5 || health > 10);
        submenu_character_creation(name, health, force);
        do {
            System.out.println("Entrez la force du Guerrier (entre 5 et 10)");
            force = keyboard.nextInt();
            keyboard.nextLine(); // Doublement car il considère entrée comme un chaine vide du coup weapon serait " "
        } while (force < 5 || force > 10);
        submenu_character_creation(name, health, force);
        System.out.println("Entrez le nom de l'arme du Guerrier");
        weapon = keyboard.nextLine();
        System.out.println("Entrer le nom du bouclier du Guerrier");
        shield = keyboard.nextLine();

        Warriors new_warrior = new Warriors(name, health, force, weapon, shield);

        System.out.println("Voici les caractéristiques de votre nouveau Guerrier\n" + "Nom : " + new_warrior.name + "\n Santé "
                + new_warrior.health + "\n Force : " + new_warrior.force + "\n Arme : " + new_warrior.weapon + "\n Bouclier : " + new_warrior.shield);

    }

    public void wizards_creation() {
        Scanner keyboard = new Scanner(System.in);
        String name;
        int health;
        int force;
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
            keyboard.nextLine(); // Le doublement comme au dessus
        } while (force < 8 || force > 15);
        System.out.println("Entrez le nom du sort du Mage");
        spell = keyboard.nextLine();
        System.out.println("Entrez le nom de la potion du Mage");
        potion = keyboard.nextLine();

        Wizards new_wizard = new Wizards(name, health, force, spell, potion);

        System.out.println("Voici les caractéristiques de votre nouveau Guerrier\n" + "Nom : " + new_wizard.name + "\n Santé "
                + new_wizard.health + "\n Force : " + new_wizard.force + "\n Sort : " + new_wizard.spell + "\n Potion : " + new_wizard.potion);

    }
    public void submenu_character_creation (String name, int health, int force ){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ? \n Afficher les infos du personnage : 1 \n" +
                "Modifier les infos du personnage : 2 \n Poursuivre la création : 3");

        switch (keyboard.nextInt()) {
                case 1:
                    System.out.println("Voici les caractéristiques du personnages \n" + "Nom " + name + "\n" + "Santé" + health + "\n" + "Force" + force);
                    submenu_character_creation(name, health, force);
                    break;
                case 2:
                    System.out.println("Modification du personnage \n Modifier le nom : 1 \n Modifier la santé : 2 \n Modifier la force : 3");
                    switch (keyboard.nextInt()) {
                        case 1:
                            System.out.println("Entrez le nouveau nom");
                            keyboard.nextLine();
                            name = keyboard.nextLine();
                            break;
                        case 2:
                            do {
                                System.out.println("Entrez la nouvelle vie du Guerrier (entre 5 et 10)");
                                health = keyboard.nextInt();
                            } while (health < 5 || health > 10);
                            break;
                        case 3:
                            do {
                                System.out.println("Entrez la nouvelle force du Guerrier (entre 5 et 10)");
                                force = keyboard.nextInt();
                                keyboard.nextLine(); // Doublement car il considère entrée comme un chaine vide du coup weapon serait " "
                            } while (force < 5 || force > 10);
                            break;
                    }

                case 3:
                    System.out.println("Reprise de la création du personnage");
                    break;
            }
        }
    }

