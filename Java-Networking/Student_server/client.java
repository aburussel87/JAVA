package Student_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",50000);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Scanner uin = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name  = uin.nextLine();
            System.out.print("Enter Id: ");
            int id = Integer.parseInt(uin.nextLine());
            System.out.print("Enter marks(Subject1 123,Subject2 234): ");
            String str = uin.nextLine();
            String[] parts = str.split(",");
            SubjectMark[] marks = new SubjectMark[3];
            for(int i = 0; i<3; i++){
                String[] p = parts[i].split(" ");
                marks[i] = new SubjectMark(p[0],Double.parseDouble(p[1]));
            }
            Student student = new Student(id, name, marks);
            out.writeObject(student);
            try {
                Double avg  = (Double)in.readObject();
                System.out.println("Your average mark: "+avg);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            out.close();
            in.close();
            socket.close();
            uin.close();
         } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
