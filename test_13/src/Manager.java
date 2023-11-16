public class Manager extends Stuff{
    private double bonus;

    public Manager() {
    }

    public Manager(String name, double salary, double bonus) {
        super(name,salary);
        this.bonus = bonus;
    }
    public void manager(){
        System.out.println("我在管理");
    }
    public double getAnnual(){
        return super.getAnnual()+this.bonus;
    }
    /**
     * 获取
     * @return bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * 设置
     * @param bonus
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String toString() {
        return "Manager{bonus = " + bonus + "}";
    }
}
