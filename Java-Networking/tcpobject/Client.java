package tcpobject;

import util.SocketWrapper;

import java.util.Scanner;

public class Client {
    private final SocketWrapper socketWrapper;

    public Client(String serverAddress, int serverPort) {
        try {
            socketWrapper = new SocketWrapper(serverAddress, serverPort);
            System.out.println("Connected to server at " + serverAddress + ":" + serverPort);

            // Start ReadThread to listen for incoming messages
            new ReadThread(socketWrapper);
            // Send unique identifier (e.g., username) to the server
            System.out.print("Enter your client ID: ");
            Scanner scanner = new Scanner(System.in);
            String clientId = scanner.nextLine();

            Data registrationData = new Data();
            registrationData.setId(1); // Special ID for registration
            registrationData.setValue(clientId);
            socketWrapper.write(registrationData);

            // Start sending messages
            sendMessageLoop(clientId, scanner);
        } catch (Exception e) {
            throw new RuntimeException("Connection failed: " + e);
        }
    }

    private void sendMessageLoop(String clientId, Scanner scanner) {
        while (true) {
            System.out.println("Enter message to broadcast: ");
            String message = scanner.nextLine();

            Data data = new Data();
            data.setId(2); // ID for broadcasting
            data.setValue(clientId + ": " + message);

            try {
                socketWrapper.write(data);
            } catch (Exception e) {
                System.out.println("Failed to send message: " + e.getMessage());
                break;
            }
        }
    }

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        new Client(serverAddress, serverPort);
    }
}
