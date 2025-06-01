import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5050;

    public static void main(String[] args) {
        System.out.println("Connecting to ChatWorld Server...");

        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected! Start chatting (type and hit Enter):");

            // Thread to read messages from the server
            new Thread(() -> {
                try {
                    String message;
                    while ((message = serverInput.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed by server.");
                }
            }).start();

            // Send user input to server
            String inputLine;
            while ((inputLine = userInput.readLine()) != null) {
                serverOutput.println(inputLine);
            }

        } catch (IOException e) {
            System.err.println(" Client Error: " + e.getMessage());
        }
    }
}