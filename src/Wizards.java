public class Wizards extends Characters {
    private Spells spell;
    private Potion potion;
    Wizards(String name, int health, int force, Spells spell ,Potion potion) {
        super(name, health, force);
        this.potion = potion;
        this.spell = spell;
    }
    Wizards (String name) {
        super(name);
    }
    Wizards(){

    }

    @Override
    public String toString() {
        return "Le nom du Mage est" + this.getName() +
                "\n sort : " + this.getSpell() +
                "\n potion : " + this.getPotion() +
                "\n santé : " + this.getHealth() +
                "\n force : "+ this.getForce() +
                '}';
    }

    public void update_wizards (String new_name, int new_health, int new_force) {
        this.name = new_name;
        this.health = new_health;
        this.force = new_force;
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