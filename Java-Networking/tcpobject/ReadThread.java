package tcpobject;

import util.SocketWrapper;

import java.io.IOException;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final SocketWrapper socketWrapper;
    private final Server server;

    // Constructor for server-side
    public ReadThread(SocketWrapper socketWrapper, Server server) {
        this.socketWrapper = socketWrapper;
        this.server = server;
        this.thr = new Thread(this);
        thr.start();
    }

    // Constructor for client-side
    public ReadThread(SocketWrapper socketWrapper) {
        this(socketWrapper, null);
    }

    public void run() {
        try {
            while (true) {
                Object o = socketWrapper.read();
                if (o instanceof Data) {
                    Data data = (Data) o;

                    if (server != null) {
                        // Server-side processing
                        if (data.getId() == 1) {
                            // Client registration
                            server.registerClient(data.getValue(), socketWrapper);
                        } else if (data.getId() == 2) {
                            // Broadcast message
                            server.broadcastMessage(data, data.getValue().split(":")[0]);
                        }
                    } else {
                        // Client-side processing
                        System.out.println("Message received: " + data.getValue());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        } finally {
            try {
                if (server != null) {
                    server.unregisterClient(socketWrapper.toString());
                }
                socketWrapper.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
