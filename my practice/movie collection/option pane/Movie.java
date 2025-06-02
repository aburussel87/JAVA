import javax.swing.JOptionPane;

public class Movie {
    private String title;
    private String genre;
    private int rating;
    private int copies;
    private int rented;

    public Movie(String t, String g, int r, int c, int rn) {
        title = t;
        genre = g;
        rating = r;
        copies = c;
        rented = rn;
    }

    public String getname() {
        return title;
    }

    public String getgenre() {
        return genre;
    }

    public int getrating() {
        return rating;
    }

    public int available() {
        return copies - rented;
    }

    public void display() {
        // System.out.println("Book details: ");
        // System.out.println("-------------");
        // System.out.print("-Title: " + title + "\n-genre: " + genre + "\n-Rating: " + rating + "\n-Available copies: "
        //         + available()+"\n");
        // System.out.println("-------------");
        JOptionPane.showMessageDialog(null,"Movie details:\n"+
        "-Title: " + title + "\n-genre: " + genre + "\n-Rating: " + rating + "\n-Available copies: "+ available()+"\n");
    }

    public void setrent(int n) {
        rented = rented + 1;
    }
    public String toFileFormat() {
        return title + "," + genre + "," + rating + "," + copies + "," + rented +"\n";
    }
}