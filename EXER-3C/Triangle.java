public class Triangle extends Shape {
    private float base;
    private float height;

    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
    }

    public float calculateArea() {
        float area = 0.5f * base * height;
        return area;
    }

    public String displayInfo() {
        return "The Area with the Triangle with Base " + this.base + " and Height " + this.height + " has area: " + calculateArea();
    }
}
