import model.Server;
import storage.IServerStorage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerListener implements Runnable{
    private static final int PACKET_SIZE = 1024;
    IServerStorage serverStorage;
    int udpFromServerPort;

    public UdpServerListener(IServerStorage serverStorage, int udpFromServerPort) {
        this.serverStorage = serverStorage;
        this.udpFromServerPort = udpFromServerPort;
    }

    @Override
    public void run() {
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

    private void handleDataFromServer(DatagramPacket packet) {
        String host = packet.getAddress().getHostAddress();

        byte[] bytes = packet.getData();
        String data = new String(bytes, 0, packet.getLength());
        System.out.println(data);
        String[] dataParts = data.split(":");

        System.out.println(dataParts[1]);
        int port = Integer.parseInt(dataParts[0]);
        int load = Integer.parseInt(dataParts[1]);

        Server server = new Server(host, port, load);
        System.out.println("Received server load data" + server.toString());
        serverStorage.update(server);
    }
}
