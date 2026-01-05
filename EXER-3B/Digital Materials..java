class DigitalItem extends LibraryItem {
    String fileFormat;
}

class EBook extends DigitalItem { double fileSizeMB; }
class Audiobook extends DigitalItem { int durationMinutes; }
