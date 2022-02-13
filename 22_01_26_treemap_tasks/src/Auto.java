public class Auto {
    public String make;
    public String model;
    public int price;

    public Auto(String make, String model, int price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
