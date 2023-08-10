public class Potion {
    private String name;
    private int value;

    Potion (String name, int value) {
        this.name = name;
        this.value = value;
    }
    public String toString(){
        return "Nom de la potion : " + getName() + "\n valeur de l'effet : " + getValue();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
