public class Worker extends Stuff{

    public Worker(String name,double salary) {
        super(name,salary);
    }

    public Worker() {
    }
    public double getAnnual(){
        return super.getAnnual()*12;
    }
    public void work(){
        System.out.println("我在工作");
    }
    public String toString() {
        return "Worker{}";
    }
}
