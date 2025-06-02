package tcpobject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import util.SocketWrapper;

public class Server {
    private ServerSocket serverSocket;
    private final Map<String, SocketWrapper> clientMap = new HashMap<>(); // Map to store clients

    Server() {
        try {
            serverSocket = new ServerSocket(33333);
            System.out.println("Server started on port 33333");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }

    public synchronized void serve(Socket clientSocket) throws IOException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        new ReadThread(socketWrapper, this); // Pass server reference to handle client actions
        System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
    }

    public synchronized void registerClient(String clientId, SocketWrapper socketWrapper) {
        clientMap.put(clientId, socketWrapper);
        System.out.println("Client registered: " + clientId);
    }

    public synchronized void unregisterClient(String clientId) {
        clientMap.remove(clientId);
        System.out.println("Client disconnected: " + clientId);
    }

    public synchronized void broadcastMessage(Data message, String senderId) {
        for (Map.Entry<String, SocketWrapper> entry : clientMap.entrySet()) {
            String clientId = entry.getKey();
            if (!clientId.equals(senderId)) { // Avoid sending to sender
                try {
                    entry.getValue().write(message);
                } catch (IOException e) {
                    System.out.println("Failed to send message to " + clientId + ": " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
