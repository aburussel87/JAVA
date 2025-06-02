public class MovieCollection{
    private static Movie[] movies = new Movie[20];
    private static int total = 0;
    
    public static void addmovie(Movie ob){
        movies[total++] = ob;
    }
    
    public static void rent(String s){

        for(int i = 0; i<total; i++){
            if(movies[i].getname().equalsIgnoreCase(s)){
                if(movies[i].available()==0){
                    System.out.println("no available copy for "+movies[i].getname());
                }else{
                System.out.println("Rent successful");
                movies[i].setrent(1);
                }
                return ;
            }
        }
        System.out.println("movie not found");
    }
    public static void search(String s){
        for(int i = 0; i<total; i++){
            if(movies[i].getname().equalsIgnoreCase(s)){
                movies[i].display();
                return ;
            }
        }
        System.out.println("Not found");
        return;
    }
}