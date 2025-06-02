public class library {
    private static book[] books = new book[20];
    private static int total = 0;

    public static void addbooks(book ob) {
        books[total++] = ob;
    }

    public static void display() {
        for (int i = 0; i < total; i++) {
            System.out.print((i+1)+".");
            books[i].display();
        }

    }
}