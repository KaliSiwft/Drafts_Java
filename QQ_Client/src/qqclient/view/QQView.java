package qqclient.view;
import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;

import java.io.IOException;
import java.util.Scanner;
public class QQView {
    private boolean loop = true;
    private String key = "";
    private String userID = "";
    private String pwd = "";
    private UserClientService userClientService = new UserClientService();
    private Scanner sc = new Scanner(System.in);


    public void mainMenu() throws IOException, ClassNotFoundException, InterruptedException {
        while (loop) {
            printFirstMenu();
            switch (key) {
                case "1":
                    loginMenu();
                    if(userClientService.checkUser(userID, pwd)) {
                        System.out.println("登入成功");
                        while (loop) {
                            printDoubletMenu();
                            switch (key) {
                                case "1" : userClientService.onlineFriendList();Thread.sleep(3*1000); break;
                                case "2" :
                                    System.out.print("请输入你要发送的信息：");
                                    String contentToAll = sc.next();
                                    MessageClientService.sendMessageToAll(contentToAll,userID);
                                    break;
                                case "3" :
                                    System.out.print("请输入想要聊天的用户号（在线）：");
                                    String getterId = sc.next();
                                    System.out.print("请输入你要发送的信息：");
                                    String content = sc.next();
                                    MessageClientService.sendMessageToOne(content, userID, getterId);
                                    break;
                                case "4" :
                                    System.out.print("请输入想要发送给谁：");
                                    String getter = sc.next();
                                    System.out.print("请输入想要发送的文件的地址：");
                                    String src = sc.next();
                                    System.out.print("请输入对方接收文件的地址：");
                                    String des = sc.next();
                                    MessageClientService.sendFileToOne(new byte[10244],userID,getter, src,des);
                                    break;
                                case "9" :
                                    userClientService.logout();
                                    loop = false; break;
                                default:

                                    System.out.printf("选择有误，请重新选择：");
                            }
                        }
                    } else {
                        System.out.println("登入失败,账号或密码有误。");
                    }
                    break;

                case "9" :
                    loop = false;
                    System.out.println("退出成功"); break;
                default:
                    System.out.println("选择有误，请重新选择.");
            }
        }
    }

    private void printFirstMenu() {
        System.out.println("==========WElCOME==========");
        System.out.println("\t\t1.登入系统");
        System.out.println("\t\t9.退出系统");
        System.out.print("请选择：");
        key = sc.next();
    }

    private void printDoubletMenu() {
        System.out.println("==========欢迎（用户 " + userID +")==========");
        System.out.println("\t\t1.显示用户列表");
        System.out.println("\t\t2.群发消息");
        System.out.println("\t\t3.私聊消息");
        System.out.println("\t\t4.发送文件");
        System.out.println("\t\t9.退出系统");
        System.out.print("请选择：");
        key = sc.next();
    }

    private void loginMenu() {
        System.out.print("请输入用户ID：");
        userID = sc.next();
        System.out.print("请输入密码：");
        pwd = sc.next();
    }
}
