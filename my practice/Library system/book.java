public class book{
    private String name;
    private String author;
    private int copies;
    private int borrowed;
    public book(String n, String a, int c, int b){
        name  = n;
        author = a;
        copies = c;
        borrowed = b;
    }
    public String getname(){
        return name;
    }
    public String getauthor(){
        return author;
    }
    public int getcopy(){
        return copies;
    }
    public int getboroowed(){
        return borrowed;
    }
    public int getava(){
        return copies - borrowed;
    }
    public void display(){
        System.out.println("name of books: "+name+" Author: "+ author+ " Available: "+ getava());
    }

}