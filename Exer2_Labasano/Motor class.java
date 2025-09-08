class Motorcycle {
    String type;
    String color;
    String brand;
    int year;

    Motorcycle(String type, String color, String brand, int year) {
        this.type = type;
        this.color = color;
        this.brand = brand;
        this.year = year;
    }

    void display() {
        System.out.println("Type: " + type + ", Color: " + color + ", Brand: " + brand + ", Year: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        Motorcycle myMotorcycle = new Motorcycle("Cruiser", "Black", "Harley-Davidson", 2023);
        myMotorcycle.display();

        Motorcycle anotherMotorcycle = new Motorcycle("Sportbike", "Red", "Honda", 2022);
        anotherMotorcycle.display();
    }
