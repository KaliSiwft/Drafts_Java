import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();
        File music = new File("Z:\\local\\Music\\Taylor Swift-Welcome To New York (Taylor's Version).flac");
        BufferedOutputStream output = new BufferedOutputStream(client.getOutputStream());
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(music));
        byte[] arr = input.readAllBytes();
        output.write(arr);
        client.shutdownOutput();
        output.close();
        input.close();
        client.close();
        server.close();
    }
}