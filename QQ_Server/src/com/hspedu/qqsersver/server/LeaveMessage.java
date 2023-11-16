package com.hspedu.qqsersver.server;
import com.hspedu.qqcommen.*;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeaveMessage {
    private static Map<String, PackMessage> hm = new LinkedHashMap<>();
    public static void setLeaveMessage(String getter, Message message) {
        if (!hm.containsKey(getter)){
            PackMessage packMessage = new PackMessage();
            packMessage.setMessage(message);
            packMessage.setNext(null);
            hm.put(getter, packMessage);
        } else {
            PackMessage packMessage = hm.get(getter);
            while (packMessage.getNext() != null) {
                packMessage = packMessage.getNext();
            }
            PackMessage tem = new PackMessage(message, null);
            packMessage.setNext(tem);
        }
    }
    public static void sendLeaveMessage(String getter) throws IOException, InterruptedException {
        if (hm.containsKey(getter)) {
            //System.out.println(hm.get(getter).getMessage().getContent() + "--------");
            PackMessage packMessage = hm.get(getter);
            while(packMessage != null) {
                ObjectOutputStream oos = new ObjectOutputStream(ManageClientThreads.getHm().get(getter).getSocket().getOutputStream());
                oos.writeObject(packMessage.getMessage());
                Thread.sleep(1 * 1000);
                System.out.println(packMessage.getMessage().getContent());
                packMessage = packMessage.getNext();
            }
            hm.remove(getter);
        }
    }
}
