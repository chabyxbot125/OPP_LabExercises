public class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }
  
    public void displayDetails() {
        System.out.println("General Library Item: " + title);
    }
}
