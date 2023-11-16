public class Main {
    public static void main(String[] args) {
    Stuff stuff1 = new Stuff("张三",112);
    Manager manager1 = new Manager("李四",223,12);
    Worker worker1 = new Worker("王五",123);
    showAnnual(stuff1);
    showAnnual(manager1);
    showAnnual(worker1);
    testShowAnnual(stuff1);
    testShowAnnual(manager1);
        ((Worker)stuff1) = worker1;
        System.out.println(stuff1==(manager1));
        System.out.println(worker1.equals(manager1));
    }
    public static void showAnnual(Stuff stuff){
        System.out.println(stuff.getAnnual());
    }
    public static void testShowAnnual(Stuff stuff){
        if(stuff instanceof Worker){
            ((Worker) stuff).work();
        }else if(stuff instanceof Manager){
            ((Manager)stuff).manager();
        }else {
            System.out.println(" ~~~~~~");
        }
    }
}