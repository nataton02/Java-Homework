package de.telran.spring_load_balancer.thread;

import de.telran.spring_load_balancer.model.Server;
import de.telran.spring_load_balancer.storage.IServerStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
@Component
public class UdpGatewaySender {
    private final String host;
    private final IServerStorage serverStorage;
    private final int udpToGatewayPort;
    private final int periodMillis;

    public UdpGatewaySender(@Value("${gateway.host}") String host,
                            IServerStorage serverStorage,
                            @Value("${udp.gateway.port}") int udpToGatewayPort,
                            @Value("${udp.gateway.sender.period}") int periodMillis) {
        this.host = host;
        this.serverStorage = serverStorage;
        this.udpToGatewayPort = udpToGatewayPort;
        this.periodMillis = periodMillis;
    }

    @Async("threadExecutor")
    public void run() {
        System.out.println("Udp gateway sender");
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            DatagramSocket udpSocket = new DatagramSocket();
            while (true) {
                try {
                    Thread.sleep(periodMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Server server = serverStorage.getOptimal();
                if(server == null)
                    continue;
                String best = server.toString();
                System.out.println("sending best server to gateway: " + best + ":" + server.getLoad());

                byte[] sendBest = best.getBytes();
                DatagramPacket packetOut = new DatagramPacket(
                        sendBest,
                        sendBest.length,
                        inetAddress,
                        udpToGatewayPort);
                udpSocket.send(packetOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
