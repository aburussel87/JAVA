public class Movie{
    private String title;
    private String genre;
    private int rating;
    private int copies;
    private int rented;
    public Movie(String t, String g, int r, int c , int rn){
        title = t;
        genre = g;
        rating = r;
        copies = c; 
        rented = rn;
    }
    public String getname(){
        return title;
    }
    public String getgenre(){
        return genre;
    }
    public int getrating(){
        return rating;
    }
    public int available(){
        return copies - rented;
    }
    public void display(){
        System.out.print("-Title: "+title+"\n-genre: "+genre+"\n-Rating: "+rating+"\nAvailable copies: "+ available());
        System.out.println();
    }
    public void setrent(int n){
        rented = rented + 1;
    }
}