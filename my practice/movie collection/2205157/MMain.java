import java.util.Scanner;

public class MMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        }

        else {
            System.err.println("Invalid command line input");
            in.close();
            return;
        } 
        for (int i = 0; i < n; i++) {
            String title;
            String genre;
            int rating;
            int copies;
            int rented;
            System.out.println("Enter information for movie: " + (i + 1));
            System.out.print("Title: ");
            title = in.nextLine();
            System.out.print("Genre: ");
            genre = in.nextLine();
            System.out.print("rating(out of 10) ");
            rating = in.nextInt();
            while (rating < 0 || rating > 10) {
                System.out.print("rating(out of 10) ");
                rating = in.nextInt();
            }
            System.out.print("Total copies: ");
            copies = in.nextInt();
            System.out.print("Rented copy: ");
            rented = in.nextInt();
            while (rented > copies) {
                System.out.print("Rented copy: ");
                rented = in.nextInt();
            }
            Movie ob = new Movie(title, genre, rating, copies, rented);
            MovieCollection.addmovie(ob);
            in.nextLine();
        }
        boolean a = true;
        while (a) {
            System.out.println("Commands: ");
            System.out.println("1. search <title> 2.rent <title>  3.exit");
            System.out.println("Enter command");
            String command = in.nextLine();
            String[] parts = command.split(" ", 2);
            if (parts[0].equals("exit")) {
                break;
            } else if (parts[0].equals("rent")) {
                MovieCollection.rent(parts[1]);
            } else if (parts[0].equals("search")) {
                MovieCollection.search(parts[1]);
            } else {
                System.out.println("Invalid command");
            }
        }

        in.close();
    }
}