import java.util.Scanner;
public class array {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int size; 
        size = in.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = in.nextInt();
        }
        in.nextLine();
        String name = in.nextLine();
        System.out.println(name);
        for(int v: arr){
            System.out.print(v+" ");
        }
        in.close();
    }
}
