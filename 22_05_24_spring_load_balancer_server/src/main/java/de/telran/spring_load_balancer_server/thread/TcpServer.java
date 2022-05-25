package de.telran.spring_load_balancer_server.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TcpServer {
    private final AtomicInteger loadCounter;
    private  final int selfTcpPort;
    private final ServerTask serverTask;

    public TcpServer(AtomicInteger loadCounter,
                     @Value("${server.tcp.inbound.port}") int selfTcpPort,
                     ServerTask serverTask) {
        this.loadCounter = loadCounter;
        this.selfTcpPort = selfTcpPort;
        this.serverTask = serverTask;
    }

    @Async("threadExecutor")
    public void run() throws IOException {
        System.out.println("Tcp server");
        try (ServerSocket serverSocket = new ServerSocket(selfTcpPort)) {

            while (true) {
                Socket socket = serverSocket.accept();
                loadCounter.incrementAndGet();
                serverTask.run(socket);
            }
        }
    }
}
