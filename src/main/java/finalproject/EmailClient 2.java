package finalproject;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EmailClient {
    private String hostName;
    private int portNumber;
    private Socket emailClientSocket;


    public EmailClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        try {
            emailClientSocket = new Socket(hostName, portNumber);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch(IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName
                    + ":" + portNumber + ". Check that the server is running.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public  void start() {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;


        try  {
             inputStreamReader = new InputStreamReader(emailClientSocket.getInputStream());
             outputStreamWriter = new OutputStreamWriter(emailClientSocket.getOutputStream());

             bufferedReader = new BufferedReader(inputStreamReader);
             bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String msgToSend = scanner.nextLine();
                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("Server: " + bufferedReader.readLine());

                if (msgToSend.equalsIgnoreCase("BYE")) {
                    break;
                }
            }
        } catch (IOException exc) {
            System.out.println("I/O exception ");
        }finally {
            try {
                if (emailClientSocket != null) {
                    emailClientSocket.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    } // end start

    public static void main(String[] args) {

        EmailClient emailClient = new EmailClient("127.0.0.1",  54321);
        emailClient.start();
    }
}
