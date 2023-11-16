import java.io.IOException;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket(8888);
        byte[] receivearr = new byte[1024];
        DatagramPacket receivepacket = new DatagramPacket(receivearr, receivearr.length);
        client.receive(receivepacket);
        System.out.println(new String(receivearr, 0, receivepacket.getLength()));

        String arr = new String("好的 明天见");
        DatagramPacket sendpacket = new DatagramPacket(arr.getBytes(), arr.getBytes().length, InetAddress.getLocalHost(), 9999);
        client.send(sendpacket);

        client.close();
    }
}