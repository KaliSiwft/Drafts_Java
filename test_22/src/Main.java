import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(9999);
        String sendarr = new String("hello 明天吃火锅");
        DatagramPacket sendpacket = new DatagramPacket(sendarr.getBytes(), sendarr.getBytes().length, InetAddress.getLocalHost(), 8888);
        server.send(sendpacket);

        byte[] receivearr = new byte[1024];
        DatagramPacket receivepacket = new DatagramPacket(receivearr, receivearr.length);
        server.receive(receivepacket);
        System.out.println(new String(receivearr, 0, receivepacket.getLength()));

        server.close();
    }
}