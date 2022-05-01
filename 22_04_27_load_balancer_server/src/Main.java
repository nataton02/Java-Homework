import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private final static int SERVER_PORT = 4005;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        LoadCounter loadCounter = new LoadCounter();

        UdpLBSender udpLBSender = new UdpLBSender(loadCounter, SERVER_PORT);
        new Thread(udpLBSender).start();


        while (true) {
            Socket socket = serverSocket.accept();
            Runnable serverTask = new ServerTask(socket, loadCounter, SERVER_PORT);
            new Thread(serverTask).start();
        }
    }
}
