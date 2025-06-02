import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;;

public class MovieCollection {
    private static Movie[] movies = new Movie[30];
    private static int total = 0;
    public static String FILE_PATH = "movies.txt";

    public static void loadmovies() {
        try {
            File file = new File("movies.txt");
            Scanner in = new Scanner(file);
            total = 0;
            while (in.hasNextLine()) {
                String m = in.nextLine();
                String[] parts = m.split(",");
                movies[total++] = new Movie(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]));
            }
            in.close();
        } catch (FileNotFoundException e) {

        }
    }

    public static void addmovie(Movie ob) {
        addMovieToFile(ob);
        loadmovies();
    }

    public static void addMovieToFile(Movie movie) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(movie.toFileFormat());
            JOptionPane.showMessageDialog(null, "Movie added to file successfully!!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error ocured while opening file!!");
            e.printStackTrace();
        }
    }

    public static void rent(String s) {

        for (int i = 0; i < total; i++) {
            String nm = (movies[i].getname()).replace(" ", "");
            String nm2 = s.replaceAll(" ", "");
            movies[i].display();
            if (nm2.equalsIgnoreCase(nm)) {
                if (movies[i].available() == 0) {
                    JOptionPane.showMessageDialog(null, "no available copy for " + movies[i].getname());
                } else {
                    JOptionPane.showMessageDialog(null, "Rented Successfully!!");
                    movies[i].setrent(1);
                    movies[i].display();
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Movie not found");
    }

    public static void search(String s) {
        for (int i = 0; i < total; i++) {
            String nm = (movies[i].getname()).replaceAll(" ", "");
            String nm2 = s.replaceAll(" ", "");
            if (nm2.equalsIgnoreCase(nm)) {
                movies[i].display();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Movie not found");
        return;
    }
    public static int gettotal(){
        return total;
    }
    public static Movie[] getMovies(){
        return movies;
    }
    public static void displayAll(){
        String x= "Total Movies: "+total+"\n";
        for(int i=0; i<total; i++){
            x = x + "Movie "+(i+1)+ " details:\n"+"~Title: " + movies[i].getname() + "    ~Genre: " + movies[i].getgenre() + "    ~Rating: " + movies[i].getrating() + "    ~Available copies: "+ movies[i]. available() +"\n\n";
            // if(i%3 == 0) x = x +"\n";
        //     JOptionPane.showMessageDialog(null,"Movie "+(i+1)+ " details:\n"+
        // "-Title: " + movies[i].getname() + "\n-genre: " + movies[i].getgenre() + "\n-Rating: " + movies[i].getrating() + "\n-Available copies: "+ movies[i]. available()+"\n");
        }
        JOptionPane.showMessageDialog(null,x);
    }
}