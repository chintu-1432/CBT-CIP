import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static final int PORT = 5050;
    private static final List<MessageHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        System.out.println(" ChatWorld Server is starting on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println(" Server is active. Waiting for users to connect...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                MessageHandler clientSession = new MessageHandler(clientSocket, clients);
                clients.add(clientSession);
                new Thread(clientSession).start();
                System.out.println(" New client connected: " + clientSocket.getInetAddress());
            }

        } catch (IOException e) {
            System.err.println(" Server Error: " + e.getMessage());
        }
    }
}