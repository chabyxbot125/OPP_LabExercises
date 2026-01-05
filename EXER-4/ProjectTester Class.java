import java.util.ArrayList;

public class ProjectTester {
    public static void main(String[] args) {
      
        ArrayList<LibraryItem> inventory = new ArrayList<>();

       
        inventory.add(new Book("Java Programming", 450, "John Smith"));
        inventory.add(new Magazine("Tech Today", 50, "January 2024"));
        inventory.add(new EBook("Cloud Architecture", "PDF", 15.5));

        System.out.println("=== LIBRARY POLYMORPHIC INVENTORY ===");
        System.out.println("--------------------------------------");

       
        for (LibraryItem item : inventory) {
            item.displayDetails();
        }
        
        System.out.println("--------------------------------------");
    }
}
