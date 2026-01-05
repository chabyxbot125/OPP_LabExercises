class DigitalItem extends LibraryItem {
    protected String fileFormat;

    public DigitalItem(String title, String fileFormat) {
        super(title);
        this.fileFormat = fileFormat;
    }
}

class EBook extends DigitalItem {
    private double fileSizeMB;

    public EBook(String title, String fileFormat, double fileSizeMB) {
        super(title, fileFormat);
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public void displayDetails() {
        System.out.println("[E-BOOK] " + title + " | Format: " + fileFormat + " | Size: " + fileSizeMB + "MB");
    }
}
