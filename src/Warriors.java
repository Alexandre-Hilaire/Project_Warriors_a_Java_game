public class Warriors extends Characters{
//    private String weapon;
    private String shield;

    Warriors (String name, int health, int force, String shield){
        super(name, health, force);
        this.shield = shield;
    }
    Warriors (String name){
        super(name);
    }
    Warriors () {

    }

    @Override
    public String toString() {
        return  "Le nom du Guerrier est \n, name='" + this.getName() +
                "\n, shield='" + this.getShield() +
                "\n, health=" + this.getHealth() +
                "\n, force=" + this.getForce() +
                '}';
    }

    public void update_warrior (String new_name, int new_health, int new_force) {
        this.name = new_name;
        this.health = new_health;
        this.force = new_force;
    }

//    public String getWeapon() {
//        return weapon;
//    }
//
//    public void setWeapon(String weapon) {
//        this.weapon = weapon;
//    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

}