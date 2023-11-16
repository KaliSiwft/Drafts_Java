public class Main {
    public static void main(String[] args) {
       Week[] weeks = Week.values();
        for(Week week : weeks) {
            System.out.println(week);
            System.out.println(week.ordinal() + 1);
        }

    }
}
@SuppressWarnings("all")
enum Week {
    Monday("星期一"), Tuesday("星期二"), Wednesday("星期三"), Thursday("星期四"), Friday("星期五"), Saturday("星期六"), Sunday("星期天");
    private String name;

    private Week(String name) {
        this.name = name;
    }

    private Week() {
    }

    public String toString() {
        return name;
    }
}
@SuppressWarnings({"all"})
class A {
    public void a(){
        System.out.println("sss");
    }
}
@SuppressWarnings("all")

class B extends A {
    @Override
    public void a() {
        System.out.println("xxx");
    }
}