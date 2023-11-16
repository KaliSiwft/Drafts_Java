package com.hspedu.qqsersver.server;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ManageClientThreads {
    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();
    public static void addClientThread(String userID, ServerConnectClientThread serverConnectClientThread) {
        hm.put(userID, serverConnectClientThread);
    }
    public static void removClientThread(String userID) {
            hm.remove(userID);
    }
    public static ServerConnectClientThread getServerConnectThread(String userID) {
        return hm.get(userID);
    }

    public static String retOnlineFriendList() {
        Iterator<String> iterator = hm.keySet().iterator();
        String st = "";
        while (iterator.hasNext()) {
            st += iterator.next().toString() + " ";
        }
        return st;
    }
}
