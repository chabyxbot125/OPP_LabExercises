public class Square extends Shape {
    private float side;

    public Square(float side) {
        this.side = side;
    }

    public float calculateArea() {
        float area = side * side;
        return area;
    }

    public String displayInfo() {
        return "The Area with the Square with Side " + this.side + " has area: " + calculateArea();
    }
}
