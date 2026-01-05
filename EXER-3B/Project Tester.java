public class ProjectTester {
    public static void main(String[] args) {
        Book b = new Book();
        EBook eb = new EBook();
        
        b.title = "Java Programming";
        eb.title = "Digital Trends 2024";

        System.out.println("Library Project items initialized: " + b.title + " and " + eb.title);
    }
}
