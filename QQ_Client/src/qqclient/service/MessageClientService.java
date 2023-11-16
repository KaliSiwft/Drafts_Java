package qqclient.service;

import com.hspedu.qqcommen.Message;
import com.hspedu.qqcommen.MessageType;

import java.io.*;
import java.time.LocalDateTime;

public class MessageClientService {
    public static void sendMessageToOne(String content, String sender, String getter) throws IOException {
        Message message = new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(content);
        message.setSendtime(LocalDateTime.now());
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
        oos.writeObject(message);
        oos.flush();
    }

    public static void sendMessageToAll(String content, String sender) throws IOException {
        Message message = new Message();
        message.setSender(sender);
        message.setContent(content);
        message.setSendtime(LocalDateTime.now());
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
        oos.writeObject(message);
        oos.flush();
    }

    public static void sendFileToOne(byte[] fileByte, String sender, String getter, String src, String des) throws IOException {
        Message message = new Message();
        message.setSender(sender);
        message.setGetter(getter);
        message.setSendtime(LocalDateTime.now());
        message.setMesType(MessageType.MESSAGE_SEND_FILE);
        message.setSrc(src);
        message.setDes(des);
        FileInputStream fis = new FileInputStream(new File(src));
        message.setFileByte(fis.readAllBytes());
        ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sender).getSocket().getOutputStream());
        oos.writeObject(message);
        oos.flush();
    }
}
