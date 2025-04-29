package finalproject;

import java.net.Socket;

public class EmailClientThread extends Thread {
    private EmailServer server;
    protected Socket socket;
    public int id;

    public EmailClientThread(Socket emailClientSocket, EmailServer server) {
        this.socket = emailClientSocket;
        this.server = server;
    }
}
