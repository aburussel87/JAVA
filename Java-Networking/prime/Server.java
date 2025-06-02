package prime;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<ObjectOutputStream> clients = new ArrayList<>();
    private static int i = 0;
    public static void main(String[] args) {
        
    }
    
    void Serve(ObjectOutputStream out, ObjectInputStream in, Socket socket){
        try{
            while(true){
                int[] x = (int[])in.readObject();
                //do calc
                out.writeObject(x);
                out.flush();
            }
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    static class clientHandler extends Thread {
        ObjectOutputStream out;
        ObjectInputStream in;
        Socket socket;

        clientHandler(ObjectOutputStream out, Socket socket, ObjectInputStream in) {
            this.socket = socket;
            this.out = out;
            this.in = in;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int[] arr = (int[]) in.readObject();
                    int x = 0;
                    for (int i = arr[0]; i <= arr[1]; i++) {
                        x += i;
                    }
                    out.writeObject(x);
                    out.flush();
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("[Disconnection]");
                i--;
            }finally{
                    synchronized(clients){
                    clients.remove(out);
                    }
                    try{
                        socket.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
            }
        }
    }
}
