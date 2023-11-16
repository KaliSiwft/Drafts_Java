import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[1024];
        DatagramSocket ds = new DatagramSocket(8888);
        DatagramPacket dp = new DatagramPacket(arr,arr.length);
        ds.receive(dp);
        System.out.println(new String(arr));
        ds.close();
    }
}