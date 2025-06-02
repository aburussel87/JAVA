import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main{
        public static void main(String[] args){
        int size = Integer.valueOf(args[0]);
        File file = new File("input.txt");
        try{
            
        Scanner in = new Scanner(file);
        for(int i = 0; i<size && in.hasNextLine(); i++){
            String name = in.next();
            String author = in.next();
            int copies = in.nextInt();
            int borrowed  = in.nextInt();
            book b  = new book(name,author,copies,borrowed);
            library.addbooks(b);
            //in.nextLine();
        }
        library.display();
        in.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}
