public class Main {
    public static void main(String[] args) {
    new Student();
    }
}

class Student extends Person {
    String age;
    int name;
    Person a = new Person();
    {
        System.out.println("我是普通代码块");
    }
    static{
        System.out.println("我是static代码块");
    }
    public Student(){
        // super();
        // 普通代码块;
        System.out.println("我是构造方法");
    }
}

class Person {
    public static String name;
    {
        System.out.println("我是普通代码块");
    }
    static{
        System.out.println("我是static代码块");
    }
    public Person(){
        System.out.println("我是构造方法");
    }
}