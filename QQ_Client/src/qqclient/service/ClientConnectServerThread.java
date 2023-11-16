package qqclient.service;
import com.hspedu.qqcommen.Message;
import com.hspedu.qqcommen.MessageType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;

public class ClientConnectServerThread extends Thread {
    private Socket socket;

    public ClientConnectServerThread() {}
    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        System.out.println("客户端的线程，等待服务端发送的消息");
        while (true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)ois.readObject();
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    System.out.println("========在线用户列表========");
                    String[] st = message.getContent().split(" ");
                    for (int i = 0; i <st.length; i ++) {
                        System.out.println("用户" + (i + 1) + ":" + " " + st[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println(message.getSender()  + " 对你说:" + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    System.out.println(message.getSender()  + " 对大家说:" + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_SEND_FILE)) {
                    System.out.println(message.getSender()  + " 给你发了份文件，在 " + message.getDes() + " 位置.");
                    FileOutputStream fos = new FileOutputStream(new File(message.getDes()));
                    fos.write(message.getFileByte());
                } else if (message.getMesType().equals(MessageType.MESSAGE_NEWS)) {
                    System.out.println(message.getSender()  + " 推送：" + message.getContent());
                }
                System.out.println("========================");
        } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
}
}
