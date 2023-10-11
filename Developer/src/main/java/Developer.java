public abstract class Developer {
    String name;
    String position;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    void drinkCoffee() {};

    String getName() {
        return name;
    }

    String getPosition() {
        return position;
    }

}
