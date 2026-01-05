public class Rectangle extends Shape {
    private float length;
    private float width;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float calculateArea() {
        float area = length * width;
        return area;
    }

    public String displayInfo() {
        return "The Area with the Rectangle with Length " + this.length + " and Width " + this.width + " has area: " + calculateArea();
    }
}
