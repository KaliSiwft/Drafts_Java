package com.hspedu.qqsersver.server;
import com.hspedu.qqcommen.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class QQServer {
    private ServerSocket ss;

    private static HashMap<String, User> valiedUser = new HashMap<>();

    static {
        valiedUser.put("100",new User("100", "100"));
        valiedUser.put("200",new User("200", "200"));
        valiedUser.put("300",new User("300", "300"));
        valiedUser.put("张三",new User("张三", "张三"));
        valiedUser.put("asdf",new User("asdf", "asdf"));
    }
    public QQServer() throws IOException, ClassNotFoundException, InterruptedException {
        System.out.println("监听端口9999");
        while (true) {
            ss = new ServerSocket(9999);
            Socket socket = ss.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            User u = (User) ois.readObject();
            Message message = new Message();
            if (checkUser(u.getUserId(), u.getPassword())) {
                message.setMesType(MessageType.MESSAGE_LOGIN_SUCCESSD);
                oos.writeObject(message);
                oos.flush();
                System.out.println("用户 " + u.getUserId() + " ,密码 " + u.getPassword() + ",登入成功。");
                ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                serverConnectClientThread.setDaemon(true);
                serverConnectClientThread.start();
                ManageClientThreads.addClientThread(u.getUserId(), serverConnectClientThread);
                LeaveMessage.sendLeaveMessage(u.getUserId());
            } else {
                System.out.println("用户 " + u.getUserId() + " ,密码 " + u.getPassword() + ",登入失败。");
                message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                oos.writeObject(message);
                oos.flush();
                ois.close();
                oos.close();
            }
            ss.close();
        }
    }
    private boolean checkUser(String userID, String pwd) {
        User u = valiedUser.get(userID);
        if (u == null) {
            return false;
        }
        if (!u.getPassword().equals(pwd)) {
            return false;
        }
        return true;
    }
}
