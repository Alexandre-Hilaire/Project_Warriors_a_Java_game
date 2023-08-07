import java.util.Scanner;

public class Warriors {
    private String name;
    private int health;
    private int force;
    private String weapon;
    private String shield;

    Warriors (String name, int health, int force, String weapon, String shield){
        this.name = name;
        this.health = health;
        this.force = force;
        this.weapon = weapon;
        this.shield = shield;
    }
    Warriors (String name){
        this.name = name;
    }
    Warriors () {

    }
    public void update_warrior (String new_name, int new_health, int new_force) {
        this.name = new_name;
        this.health = new_health;
        this.force = new_force;
    }

    public String toString(){
        return name+ " " + health + " "+ force + " " + weapon + " " + shield;
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