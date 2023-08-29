package characters;

public class Warriors extends Characters{
//    private String weapon;
    private String shield;

    public Warriors (String name, int health, int force, String shield){
        super(name, health, force);
        this.shield = shield;
    }
    public Warriors (String name){
        super(name);
    }
    public Warriors () {

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