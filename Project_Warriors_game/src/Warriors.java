public class Warriors {
    String name;
    int health;
    int force;
    String weapon;
    String shield;

    Warriors (String name, int health, int force, String weapon, String shield){
        this.name = name;
        this.health = health;
        this.force = force;
        this.weapon = weapon;
        this.shield = shield;
    }
    Warriors () {

    }

    public String toString(){
        return name+ " " + health + " "+ force + " " + weapon + " " + shield;
    }

    public void update_warrior () {
        this.name = name;
        this.health = health;
        this.force = force;
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

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }
}