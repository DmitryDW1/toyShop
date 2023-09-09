package toyShop.model;

public class Toy {
    private String id;
    private String name;
    private double weight;
    public Toy(String id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }


    public Double setWeight(double weight) {
        this.weight = weight;
        return weight;
    }

    @Override
    public String toString() {
        return "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", weight=" + getWeight();
    }

}