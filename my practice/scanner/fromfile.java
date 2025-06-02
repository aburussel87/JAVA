import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class fromfile {
    public static void main(String[] args) {
        try{
            File file =new File ("in.txt");
            Scanner in  = new Scanner(file);
            int size = in.nextInt();
            in.nextLine();
            int[] arr = new int[size];
            String a  = in.nextLine();
            String[] parts = a.split(" ");
            for(int i = 0; i<size; i++)
            {
                arr[i] = Integer.parseInt(parts[i]);
            }
            for(int i = 0; i<size; i++){
                System.out.print(arr[i]+" ");
            }
            in.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            //e.printStackTrace();
        }
    }
}
