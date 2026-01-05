public class Circle extends Shape {
    private float radius;
    final float PI = 3.1415f;

    public Circle(float radius) {
        this.radius = radius;
    }
    
    public float calculateArea() {
       float area = PI * (radius * radius);
       return area;
    }

   
    public String displayInfo() {
        return "The Area of a Circle with Radius " + this.radius + " has area: " + calculateArea();

    }

    
}
