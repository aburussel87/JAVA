import java.util.Scanner;
public class string{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.nextLine();
        String c = in.next();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        in.close();
    }
}