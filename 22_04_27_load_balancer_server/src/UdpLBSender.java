import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpLBSender implements Runnable{
    private LoadCounter loadCounter;
    private int port;

    public UdpLBSender(LoadCounter loadCounter, int port) {
        this.loadCounter = loadCounter;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            InetAddress inetAddress = InetAddress.getByName("localhost");
            DatagramSocket udpSocket = new DatagramSocket();
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String serverLoad = port + ":" + loadCounter.getCounter();
                System.out.println("sending server load to load balancer: " +  serverLoad);

                byte[] bytesLoad = serverLoad.getBytes();

                DatagramPacket packetOut = new DatagramPacket(
                        bytesLoad,
                        bytesLoad.length,
                        inetAddress,
                        3000);
                udpSocket.send(packetOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
