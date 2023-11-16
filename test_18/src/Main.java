public class Main {
    public static void main(String[] args) {

    }
}

class Outer {
    int m = 0;
    void test1 (){
        System.out.println("外部成员方法test1");
    }
    void test2() {
        class Inner {
            int n = 1;
            void show() {
                System.out.println("外部成员变量m=" + m);
                test1();
            }
        }
        Inner inner = new Inner();
        System.out.println(inner.n);
        inner.show();
    }
    
}