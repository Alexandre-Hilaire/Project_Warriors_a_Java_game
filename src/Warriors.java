public class Warriors extends Characters{
    private Weapons weapon;
    private Shields shield;
    Warriors (String name, int health, int force, Weapons weapon, Shields shield){
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
                "\n Santé : " + this.getHealth()+
                "\n Force : " + this.getForce() +
                "\n Bouclier : " + this.shield +
                "\n Armes : " + this.weapon;
    }

    public void update_warrior (String new_name, int new_health, int new_force) {
        this.name = new_name;
        this.health = new_health;
        this.force = new_force;
    }

}