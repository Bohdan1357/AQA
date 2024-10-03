package task4_3;

public class GenericBook implements Printable {
    private String title;

    public GenericBook(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Title of the book: " + title);
    }
}