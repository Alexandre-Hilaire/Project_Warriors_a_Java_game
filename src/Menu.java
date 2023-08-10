import java.util.Scanner;

public class Menu {
    String name;
    int health = 0;
    int force = 0;
    boolean is_warrior = false;
    boolean is_wizard = false;

    public void menu() {
        Scanner keyboard = new Scanner(System.in);
        String key;
        System.out.println("Enter \"1\" Pour créer un personnage, \"2\" pour commencer une partie \"0\" pour quitter le jeu");
        key = keyboard.nextLine();
        switch (key) {
            case "1":
                System.out.println("Vous entrez dans le menu création de personnage");
                new_character_creation_menu();
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

    public void new_character_creation_menu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choisissez la classe du personnage \n 1 Guerrier \n 2 Mage \n 3 Retour au menu principal");
        switch (keyboard.nextInt()) {
            case 0:
                System.out.println("Merci d'avoir joué");
                System.exit(0);
                break;
            case 1:
                System.out.println("Guerrier");
                is_warrior = true;
                character_creation();
                break;
            case 2 :
                System.out.println("Mage");
                is_wizard = true;
                character_creation();
                break;
            case 3:
                System.out.println("Retour au menu principal");
                Menu menu = new Menu();
                menu.menu();
        }
        //keyboard.close();
        Menu menu = new Menu();
        menu.menu();
    }
    public void character_creation () {
        if (is_warrior){
            create_warrior();
        }
        else if (is_wizard) {
            create_wizard();
        }

    }
    public void create_warrior (){
        characters_basics_specs();
        Weapons weapon = warrior_weapons_creation();
        Shields shield = warrior_shields_creation();
        Warriors new_warrior = new Warriors(name, health, force, weapon, shield);
        submenu_character_creation(new_warrior);
        System.out.println(new_warrior);
    }
    public void create_wizard (){
        characters_basics_specs();
        Spells spell = wizard_spells_creation();
        Potion potion = wizard_potions_creation();
        Wizards new_wizard = new Wizards(name, health, force, spell, potion);
        submenu_character_creation(new_wizard);
        System.out.println(new_wizard);
    }
    public void characters_basics_specs (){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage");
        this.name = keyboard.nextLine();
        if (is_warrior){
            do {
            System.out.println("Entrez la vie du Guerrier (entre 5 et 10)");
            this.health = keyboard.nextInt();
            keyboard.nextLine();
            } while (health < 5 || health > 10);
            do {
                System.out.println("Entrez la force du Guerrier (entre 5 et 10)");
                this.force = keyboard.nextInt();
                keyboard.nextLine(); // Doublement, car il considère entrée comme une chaine vide du coup weapon serait " "
            } while (force < 5 || force > 10);
        }
        else if (is_wizard){
            do {
                System.out.println("Entrez la vie du Mage (entre 3 et 6)");
                this.health = keyboard.nextInt();
            } while (health < 3 || health > 6);
            do {
                System.out.println("Entrez la force du Mage (entre 8 et 15)");
                this.force = keyboard.nextInt();
                keyboard.nextLine(); // Le doublement comme dessus
            } while (force < 8 || force > 15);
        }
    }
    public Weapons warrior_weapons_creation (){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrez le nom de l'arme du Guerrier");
        String weapon_name = keyboard.nextLine();
        System.out.println("Entrez les dégats de l'arme");
        int weapon_damages = keyboard.nextInt();
        keyboard.nextLine();
        return new Weapons(weapon_name, weapon_damages);
    }
    public Shields warrior_shields_creation (){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrez le nom du bouclier");
        String shield_name = keyboard.nextLine();
        System.out.println("Entrez la valeur de protection du bouclier");
        int shield_armor = keyboard.nextInt();
        keyboard.nextLine();
        return new Shields(shield_name,shield_armor);
    }

    public Spells wizard_spells_creation (){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrez le nom du sort");
        String spell_name = keyboard.nextLine();
        System.out.println("Entrez la valeur d'effet du sort");
        int spell_effect = keyboard.nextInt();
        keyboard.nextLine();
        return new Spells(spell_name, spell_effect);
    }
    public Potion wizard_potions_creation (){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrez le nom de la potion");
        String potion_name = keyboard.nextLine();
        System.out.println("Entrez la valeur d'effet de la potion");
        int potion_effect = keyboard.nextInt();
        return new Potion(potion_name,potion_effect);
    }
    public void submenu_character_creation (Characters new_character) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Que voulez-vous faire ? \n Afficher les infos du personnage : 1 \n" +
                "Modifier les infos du personnage : 2 \n Poursuivre la création : 3");

        switch (keyboard.nextInt()) {
            case 1:
                System.out.println("Voici les caractéristiques du personnages \n" + "Nom " + new_character.getName() + "\n" + "Santé" + new_character.getHealth() + "\n" + "Force" + new_character.getForce());
                submenu_character_creation(new_character);
                break;
            case 2:
                if (is_warrior) {
                    update_warriors(this.name, this.health, this.force);
                }
                else if (is_wizard){
                    update_wizards(this.name, this.health, this.force);
                }
                break;

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


