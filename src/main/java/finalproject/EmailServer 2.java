package finalproject;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class EmailServer {
    public int portNumber;
    private ServerSocket serverSocket = null;
    private List<EmailClientThread> emailClients;

    public EmailServer(int portNumber) {
        this.portNumber = portNumber;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException exc) {
            System.out.println("Exception caught when trying to listen on port" + portNumber);
        }
    } // end of EmailServer

    public void start() {
        System.out.println("Would you like to login or create a new account?");
        while (true) {
            Socket socket = null;
            InputStreamReader inputStreamReader = null;
            OutputStreamWriter outputStreamWriter = null;
            BufferedReader bufferedReader = null;
            BufferedWriter bufferedWriter = null;

            try {
                 socket = serverSocket.accept();
                 inputStreamReader = new InputStreamReader(socket.getInputStream());
                 outputStreamWriter = new OutputStreamWriter((socket.getOutputStream()));

                 bufferedReader = new BufferedReader(inputStreamReader);
                 bufferedWriter = new BufferedWriter(outputStreamWriter);

                while (true) {
                    String msgFromClient = bufferedReader.readLine();

                    if (msgFromClient == null) {
                        System.out.println("Client disconnected unexpectedly.");
                        break;
                    }

                    System.out.println("Client: " + msgFromClient);

                    bufferedWriter.write("MSG received");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if (msgFromClient.equalsIgnoreCase("BYE")) {
                        break;
                    }
                }
            } catch (IOException exc) {
                System.out.println("Error handling  client: " + exc.getMessage());
            } finally {
                try {
                    if (socket != null)
                        socket.close();
                    if (inputStreamReader != null)
                        inputStreamReader.close();
                    if (outputStreamWriter != null)
                        outputStreamWriter.close();
                    if (bufferedReader != null)
                        bufferedReader.close();
                    if (bufferedWriter != null)
                        bufferedWriter.close();
                    System.out.println("Connection resources closed. Waiting for new clients...");
                } catch (IOException exc) {
                    System.out.println("Error closing client resources" + exc.getMessage());
                }
            }
        }

//        newClient
    }  // end of start

    public static void main(String[] args) {
        try { // prints localhost
            System.out.println("Server IP: " + InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException: " + e);
        }
        /*
        should specify a port number in the dynamic/private port range (49152-65535)
        to avoid conflicts with standard services. Common choices for educational
        applications include:
        55555
        54321
        50000
        60000
         */
        int portNumber = 54321;
        EmailServer emailServer = new EmailServer(portNumber);
        emailServer.start();
    } // end of main
}
