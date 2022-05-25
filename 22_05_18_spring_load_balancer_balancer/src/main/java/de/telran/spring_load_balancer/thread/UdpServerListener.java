package de.telran.spring_load_balancer.thread;

import de.telran.spring_load_balancer.model.Server;
import de.telran.spring_load_balancer.storage.IServerStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
@Component
public class UdpServerListener {
    private static final int PACKET_SIZE = 1024;
    IServerStorage serverStorage;
    int udpFromServerPort;

    public UdpServerListener(IServerStorage serverStorage, @Value("${udp.balancer.port") int udpFromServerPort) {
        this.serverStorage = serverStorage;
        this.udpFromServerPort = udpFromServerPort;
    }

    @Async("threadExecutor")
    public void run() {
        System.out.println("Udp server listener");
        DatagramSocket serverUdpSocket;
        try {
            serverUdpSocket = new DatagramSocket(udpFromServerPort);
        } catch(SocketException e) {
            e.fillInStackTrace();
            return;
        }
        byte[] dataIn = new byte[PACKET_SIZE];
        DatagramPacket packetIn = new DatagramPacket(dataIn, PACKET_SIZE);

        try {
            while (true) {
                serverUdpSocket.receive(packetIn);
                handleDataFromServer(packetIn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void handleDataFromServer(DatagramPacket packet) {
        String host = packet.getAddress().getHostAddress();

        byte[] bytes = packet.getData();
        String data = new String(bytes, 0, packet.getLength());
        String[] dataParts = data.split(":");

        int port = Integer.parseInt(dataParts[0]);
        int load = Integer.parseInt(dataParts[1]);

        Server serverData = new Server(host, port, load);
        serverStorage.update(serverData);
    }
}
