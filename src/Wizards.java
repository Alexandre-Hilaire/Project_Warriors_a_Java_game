public class Wizards extends Characters {
    private Spells spell;
    private Potion potion;

    Wizards(String name, int health, int force, Spells spell, Potion potion) {
        super(name, health, force);
        this.potion = potion;
        this.spell = spell;
    }

    Wizards(String name) {
        super(name);
    }

    Wizards() {

    }

    @Override
    public String toString() {
        return "Le nom du Mage est" + this.getName() +
                "\n santé : " + this.getHealth() +
                "\n force : " + this.getForce() +
                "\n sort : " + this.spell +
                "\n potion : " + this.potion;
    }

    public void update_wizards(String new_name, int new_health, int new_force) {
        this.name = new_name;
        this.health = new_health;
        this.force = new_force;
    }
}