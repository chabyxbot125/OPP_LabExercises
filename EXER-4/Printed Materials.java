class PrintedItem extends LibraryItem {
    protected int pageCount;

    public PrintedItem(String title, int pageCount) {
        super(title);
        this.pageCount = pageCount;
    }
}

class Book extends PrintedItem {
    private String author;

    public Book(String title, int pageCount, String author) {
        super(title, pageCount);
        this.author = author;
    }

    @Override
    public void displayDetails() {
        System.out.println("[BOOK] " + title + " | Author: " + author + " | Pages: " + pageCount);
    }
}

class Magazine extends PrintedItem {
    private String issueDate;

    public Magazine(String title, int pageCount, String issueDate) {
        super(title, pageCount);
        this.issueDate = issueDate;
    }

    @Override
    public void displayDetails() {
        System.out.println("[MAGAZINE] " + title + " | Issue: " + issueDate);
    }
}
