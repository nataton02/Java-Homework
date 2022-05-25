package de.telran.spring_load_balancer_server;

import de.telran.spring_load_balancer_server.thread.LoadSender;
import de.telran.spring_load_balancer_server.thread.ServerTask;
import de.telran.spring_load_balancer_server.thread.TcpServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Server implements CommandLineRunner {
    private final LoadSender loadSender;
    private final TcpServer tcpServer;

    public Server(LoadSender loadSender, TcpServer tcpServer) {
        this.loadSender = loadSender;
        this.tcpServer = tcpServer;
    }

    @Override
    public void run(String... args) throws Exception {
        loadSender.run();
        tcpServer.run();

    }
}
