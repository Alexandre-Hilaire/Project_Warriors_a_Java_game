public class Shields {
    private String name;
    private int armor;

    public Shields (String name, int armor) {
        this.name = name;
        this.armor = armor;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
