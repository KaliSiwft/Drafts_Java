package com.hspedu.qqsersver.server;
import com.hspedu.qqcommen.Message;
import com.hspedu.qqcommen.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class News extends Thread{
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            Message message = new Message();
            System.out.println("请输入要推送的消息：");
            message.setContent(sc.next());
            message.setMesType(MessageType.MESSAGE_NEWS);
            message.setSender("服务端");
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
            Iterator iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(hm.get(iterator.next()).getSocket().getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("服务器 推送 新闻");
        }
    }
}
