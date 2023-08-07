public class Wizards {
    String name;
    int health;
    int force;
    String spell;
    String potion;

    public Wizards(String name, int health, int force, String spell, String potion) {
        this.name = name;
        this.health = health;
        this.force = force;
        this.spell = spell;
        this.potion = potion;
    }
    Wizards (String name) {
        this.name = name;
    }
    Wizards(){

    }
    public void update_wizards (String new_name, int new_health, int new_force) {
        this.name = new_name;
        this.health = new_health;
        this.force = new_force;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getPotion() {
        return potion;
    }

    public void setPotion(String potion) {
        this.potion = potion;
    }
}