package qqclient.service;
import com.hspedu.qqcommen.Message;
import com.hspedu.qqcommen.MessageType;
import com.hspedu.qqcommen.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.management.MemoryNotificationInfo;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class UserClientService {
    private User u = new User();
    private Socket socket = null;

    public UserClientService() {}
    public boolean checkUser(String userID, String pwd) throws IOException, ClassNotFoundException, InterruptedException {
        u.setUserId(userID);
        u.setPassword(pwd);
        boolean b = false;
        socket = new Socket(InetAddress.getLocalHost(), 9999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(u);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message ms = (Message)ois.readObject();
        if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCESSD)) {
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();
            ManageClientConnectServerThread.addClientConnectServerThread(u.getUserId(), clientConnectServerThread);
            b = true;
        } else {
            Thread.sleep(3 * 1000);
            socket.close();
        }
        return b;
    }
    public void onlineFriendList() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream
                (ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
        Message m1 = new Message();
        m1.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        m1.setSender(u.getUserId());
        oos.writeObject(m1);
        oos.flush();
        //oos.close();
    }

    public void logout() throws IOException {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(message);
        oos.flush();
        System.out.println(u.getUserId() + " 退出了系统。");
        System.exit(0);
    }
}
