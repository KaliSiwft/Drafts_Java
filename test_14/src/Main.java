import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person a = new Person("张三",18,'男');
        Person c = new Person("张三",18,'男');
        Person b = new Person("李四",20,'女');
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));"123".equals("321");
        System.out.println(a);
        Object d = new Object();
        System.out.println(d.hashCode());
        System.out.println(d);
        int[] arr = {3,2,2,1};
        Person.printStream();
    }
}