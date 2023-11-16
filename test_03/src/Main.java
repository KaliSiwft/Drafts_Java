import java.net.SocketOption;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
/*        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a < 2)System.out.print("输入错误");
        else {
            int i = 0;
            for(i = a -1; i > 1; i--){
              if(a % i == 0) {
                  System.out.println(a + "不是质数");
                  break;
              }
            }
            if(i == 1)System.out.print(a + "是质数");
        }*/
        GirlFriend Friend1;
        Friend1 = new GirlFriend();
        Friend1.age = 18;
        Friend1.height = 170;
        Friend1.weight = 100;
        Friend1.DoSomeShopping();
        Friend1.PlayGame();
        System.out.println("age = " + Friend1.age + ",height = " + Friend1.height + ",weight = " + Friend1.weight);
    }
}