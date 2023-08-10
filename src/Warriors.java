public class Warriors extends Characters{
//    private String weapon;
    private Weapons weapon;
    private Shields shield;
    Warriors (String name, int health, int force, Shields shield, Weapons weapon){
        super(name, health, force);
        this.shield = shield;
        this.weapon = weapon;
    }
    Warriors (String name){
        super(name);
    }
    Warriors () {
        //super(name);
    }

    @Override
    public String toString() {
        return  "Le nom du Guerrier est " + this.getName() +
                "\n, shield=" + this.getShield() +
                "\n, health=" + this.getHealth() +
                "\n, force=" + this.getForce() +
                '}';
    }

    public void update_warrior (String new_name, int new_health, int new_force) {
        this.name = new_name;
        this.health = new_health;
        this.force = new_force;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

}