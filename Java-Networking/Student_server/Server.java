package Student_server;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(50000);
            System.out.println("Server is waiting........");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected!!");
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                Student student = null;
                try {
                    student = (Student)in.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if(student!=null){
                    System.out.println("Name: "+student.getName()+" ID:"+student.getID());
                    out.writeObject(student.avg());
                }else{
                    out.writeObject(null);
                }
                out.flush();
                in.close();
                out.close();
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
}
