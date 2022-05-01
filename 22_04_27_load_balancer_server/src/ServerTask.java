import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerTask implements Runnable{
    private final Socket socket;
    private LoadCounter counter;
    private int port;

    public ServerTask(Socket socket, LoadCounter counter, int port) {
        this.socket = socket;
        this.counter = counter;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            counter.increment();
            PrintStream dataOut = new PrintStream(socket.getOutputStream());
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = dataIn.readLine()) != null) {
                String response = line + " handled by server on " + port;
                dataOut.println(response);
            }
            counter.decrement();
            System.out.println("Socket closed");
        } catch (IOException e) {
            e.printStackTrace();
            counter.decrement();
        }

    }
}
