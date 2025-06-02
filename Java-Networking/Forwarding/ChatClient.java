package Forwarding;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private String name;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ChatClient(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            name = scanner.nextLine();

            // Send name to server
            out.writeObject(name);
            out.flush();

            // Read server welcome message
            System.out.println((String) in.readObject());

            // Start thread for receiving messages
            new Thread(this::receiveMessages).start();

            // Start sending messages
            sendMessages(scanner);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendMessages(Scanner scanner) {
        try {
            while (true) {
                System.out.print("To (Enter 'all' to broadcast): ");
                String recipient = scanner.nextLine();
                System.out.print("Message: ");
                String message = scanner.nextLine();

                Message msg = new Message(recipient,name, message);
                out.writeObject(msg);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Connection lost. Exiting...");
        }
    }

    private void receiveMessages() {
        try {
            while (true) {
                String received = (String) in.readObject();
                System.out.println("\n[New Message]: " + received);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Disconnected from server.");
        }
    }

    public static void main(String[] args) {
        new ChatClient("192.168.0.194", 50000);  // Connect to localhost server
    }
}
