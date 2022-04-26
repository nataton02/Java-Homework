import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private final static int SERVER_PORT = 3000;
    // Хотим сделать сервер, который открывает поток для каждонр входящего соединения и обрабатываеи его
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        // Переделать TCP сервер таким образом, чтобы тот использовал Thread Pool из 10 потоков
        // для обработки входящих соединений.

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket socket = serverSocket.accept();
            Runnable serverTask = new ServerTask(socket);
            executorService.execute(serverTask);
        }

    }
}
