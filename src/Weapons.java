public class Weapons {
    private String name;
    private int damages;

    Weapons(String name, int damages){
        this.name = name;
        this.damages = damages;
    }
    public String toString() {
        return "Le nom de l'arme est " + this.getName() +
                "\n Les dégats de " + this.getName() + " : " + this.getDamages();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamages() {
        return damages;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }
}
