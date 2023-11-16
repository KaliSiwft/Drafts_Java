package qqclient.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    public static void addClientConnectServerThread (String userID, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userID, clientConnectServerThread);
    }

    public static ClientConnectServerThread getClientConnectServerThread (String userID) {
        return hm.get(userID);
    }
}
