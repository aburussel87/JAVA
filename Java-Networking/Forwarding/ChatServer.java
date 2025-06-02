package Forwarding;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServer {
    private static HashMap<String, ObjectOutputStream> clients = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(50000)) {
            System.out.println("Chat Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                

                // Read client name
                String name = (String) in.readObject();
                System.out.println("New client connected: " + name);

                synchronized (clients) {
                    clients.put(name, out);
                }

                out.writeObject("Welcome " + name + "! You can now send messages.");
                out.flush();

                // Start a new thread for the client
                new ServeClient(name, out, in, socket).start();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class ServeClient extends Thread {
        private String name;
        private ObjectOutputStream out;
        private ObjectInputStream in;
        private Socket socket;

        ServeClient(String name, ObjectOutputStream out, ObjectInputStream in, Socket socket) {
            this.name = name;
            this.out = out;
            this.in = in;
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Message message = (Message) in.readObject();

                    if (message.getTo().equalsIgnoreCase("all")) {
                        // Broadcast to everyone EXCEPT the sender
                        synchronized (clients) {
                            for (String client : clients.keySet()) {
                                if (!client.equals(name)) { 
                                    clients.get(client).writeObject(name + ": " + message.getSms());
                                    clients.get(client).flush();
                                }
                            }
                        }
                    } else {
                        // Private message
                        synchronized (clients) {
                            ObjectOutputStream recipientOut = clients.get(message.getTo());
                            if (recipientOut != null) {
                                recipientOut.writeObject(name + " (private): " + message.getSms());
                                recipientOut.flush();
                            } else {
                                out.writeObject("User " + message.getTo() + " not found.");
                                out.flush();
                            }
                        }
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(name + " disconnected.");
            } finally {
                synchronized (clients) {
                    clients.remove(name);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
