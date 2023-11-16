import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getLocalHost(), 9999);
        File music = new File("Z:\\Taylor Swift-Welcome To New York (Taylor's Version).flac");
        //BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //String st = reader.readLine();
        BufferedInputStream input = new BufferedInputStream(client.getInputStream());
        BufferedOutputStream output= new BufferedOutputStream(new FileOutputStream(music));
        byte[] arr = input.readAllBytes();
        client.shutdownInput();
        output.write(arr);
        output.close();
        input.close();
        client.close();
    }
}