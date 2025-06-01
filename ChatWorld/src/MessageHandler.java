import java.io.*;
import java.net.Socket;
import java.util.List;

public class MessageHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;
    private List<MessageHandler> connectedClients;

    public MessageHandler(Socket socket, List<MessageHandler> clients) {
        this.clientSocket = socket;
        this.connectedClients = clients;

        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            output = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println(" Error initializing client session: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            output.println(" Welcome to ChatWorld!");

            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                String formattedMessage = "[User@" + clientSocket.getInetAddress().getHostAddress() + "]: " + clientMessage;
                broadcast(formattedMessage);
            }

        } catch (IOException e) {
            System.out.println(" User disconnected: " + clientSocket.getInetAddress());
        } finally {
            disconnect();
        }
    }

    private void broadcast(String message) {
        for (MessageHandler client : connectedClients) {
            client.output.println(message);
        }
    }

    private void disconnect() {
        try {
            connectedClients.remove(this);
            clientSocket.close();
        } catch (IOException e) {
            System.err.println(" Error closing connection.");
        }
    }
}