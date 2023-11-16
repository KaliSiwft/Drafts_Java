package com.hspedu.qqsersver.server;

import com.hspedu.qqcommen.Message;
import com.hspedu.qqcommen.MessageType;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userID;
    public ServerConnectClientThread(Socket socket, String userID) {
        this.socket = socket;
        this.userID = userID;
    }

    public Socket getSocket() {
        return socket;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("服务端和客户端 " + userID + " 保持通讯");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    System.out.println(message.getSender() + " 要用户在线列表。");
                    Message m2 = new Message();
                    m2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    m2.setGetter(message.getGetter());
                    m2.setContent(ManageClientThreads.retOnlineFriendList());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(m2);
                    oos.flush();
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + " 退出了系统。");
                    ManageClientThreads.removClientThread(message.getSender());
                    socket.close();
                    break;
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    if (ManageClientThreads.getHm().containsKey(message.getGetter())) {
                        ObjectOutputStream oos = new ObjectOutputStream(ManageClientThreads.getServerConnectThread(message.getGetter()).socket.getOutputStream());
                        oos.writeObject(message);
                        System.out.println(message.getSender()  + " 对" + message.getGetter() + " 说:" + message.getContent());
                    } else {
                        LeaveMessage.setLeaveMessage(message.getGetter(), message);
                        System.out.println(message.getSender()  + " 对" + message.getGetter() + " 留言:" + message.getContent());
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
                    Iterator<String> iterator = hm.keySet().iterator();
                    while (iterator.hasNext()) {
                        String id = iterator.next().toString();
                        if(!id.equals(message.getSender())) {
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(id).socket.getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_SEND_FILE)) {
                    ObjectOutputStream oos = new ObjectOutputStream(ManageClientThreads.getServerConnectThread(message.getGetter()).socket.getOutputStream());
                    oos.writeObject(message);
                    System.out.println(message.getSender()  + " 给" + message.getGetter() + "发了文件");
                }

            }catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
