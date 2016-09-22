public class MainApplication {
    public static void main(String[] args) {
        new LibraryController(new Library());
        new ReviewController();
    }
}
