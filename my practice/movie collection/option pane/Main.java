import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        MovieCollection.loadmovies();
        Scanner in = new Scanner(System.in);
        // if (args.length == 1) {
        // n = Integer.parseInt(args[0]);
        // } else {
        // System.err.println("Invalid command line input");
        // in.close();
        // return;
        // }
        int response = JOptionPane.showConfirmDialog(null, "Are you admin?");
        if (response == JOptionPane.YES_OPTION) {
            String pass = "aburussel87";
            String temp_pass;
            temp_pass = JOptionPane.showInputDialog(null, "Enter your password: ");
            while (!pass.equals(temp_pass)) {
                temp_pass = JOptionPane.showInputDialog(null, "Enter valid password: ");
            }
            while (true) {
                String command = JOptionPane.showInputDialog(null,
                        "Commands: \n1.Add \n2. search <title> \n3. display \n4.exit");
                // System.out.println("Commands: ");
                // System.out.print("Enter command: ");
                // String command = in.nextLine();
                String[] parts = command.split(" ", 2);
                if (parts[0].equals("exit")) {
                    JOptionPane.showMessageDialog(null, "Exited Successfully!!");
                    break;
                } else if (parts[0].equalsIgnoreCase("add")) {
                    int n;
                    n = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of movies you want to add: "));
                    for (int i = 0; i < n; i++) {
                        String title;
                        String genre;
                        int rating;
                        int copies;
                        int rented;
                        title = JOptionPane.showInputDialog(null, "Enter info for movie " + (i + 1) + "\nTitle: ");
                        genre = JOptionPane.showInputDialog(null, "Genre: ");
                        rating = Integer.parseInt(JOptionPane.showInputDialog(null, "Rating: "));
                        while (rating > 10 || rating < 0) {
                            rating = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Invalid rating(out of 10)\n" + "Rating: "));
                        }
                        copies = Integer.parseInt(JOptionPane.showInputDialog(null, "Copies: "));
                        rented = Integer.parseInt(JOptionPane.showInputDialog(null, "Rented copies: "));
                        while (rented > copies) {
                            rented = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Invalid renting\n" + "Rented copies: "));
                        }
                        Movie ob = new Movie(title, genre, rating, copies, rented);
                        MovieCollection.addmovie(ob);
                    }
                } else if (parts[0].equals("search") && parts.length == 2) {
                    MovieCollection.search(parts[1]);
                } else if (parts[0].equals("display")) {
                    // for (int i = 0; i < MovieCollection.gettotal(); i++) {
                    //     MovieCollection.getMovies()[i].display();
                    // }
                    MovieCollection.displayAll();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Command!!!");
                }
            }

        } else {
            while (true) {
                String command = JOptionPane.showInputDialog(null,
                        "Commands: \n1. search <title> \n2.rent <title> \n3.exit");
                // System.out.println("Commands: ");
                // System.out.print("Enter command: ");
                // String command = in.nextLine();
                String[] parts = command.split(" ", 2);
                if (parts[0].equals("exit")) {
                    JOptionPane.showMessageDialog(null, "Exited Successfully!!");
                    break;
                } else if (parts[0].equals("rent") && parts.length == 2) {
                    MovieCollection.rent(parts[1]);
                } else if (parts[0].equals("search") && parts.length == 2) {
                    MovieCollection.search(parts[1]);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Command!!!");
                }
            }
        }

        in.close();
    }
}
