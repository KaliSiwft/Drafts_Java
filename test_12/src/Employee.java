public class Employee extends Staff {
    public void work(){
        System.out.println("work");
    }
    public Employee(String name, double salary){
        super(name,salary);
    }
    public double getAnnual(){
        return super.getSalary();
    }
}
