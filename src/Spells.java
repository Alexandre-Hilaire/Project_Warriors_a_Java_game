public class Spells {
    private String name;
    private int damages;
    Spells(String name, int damages){
        this.name = name;
        this.damages = damages;
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
