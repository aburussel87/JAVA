package prime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

class client {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    client(){
        start();
    }
    public void start() {
        try {
            socket = new Socket("localhost", 50000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            new Thread(this::recieve).start();
            send();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
            socket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    void recieve(){
        try{
            while(true){
                int x = (int)in.readObject();
                System.out.println("Sum is: "+x);
            }
        }catch(ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
    }

    void send(){
        Scanner sc = new Scanner(System.in);
        try{
            while(true){
                System.out.print("Enter two numbers: ");
                int x,y;
                x = sc.nextInt();
                y = sc.nextInt();
                sc.nextLine();
                int[] arr = {x,y};
                out.writeObject(arr);
                out.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        sc.close();
    }
    public static void main(String[] args) {
        client cl = new client();
    }
}
