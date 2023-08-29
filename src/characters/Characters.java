package characters;

abstract class Characters {
    public String name;
    public int health;
    public int force;
    Characters (String name){
        this.name = name;
    }
    Characters (String name, int health, int force){
        this.name = name;
        this.health = health;
        this.force = force;
    }
    Characters (){
    }


    public String toString() {
        return this.name + " " + this.health + " " + this.force;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getForce() {
        return this.force;
    }

    public void setForce(int force) {
        this.force = force;
    }

}
