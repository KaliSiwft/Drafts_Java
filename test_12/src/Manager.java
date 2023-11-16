public class Manager extends Staff{
    private double bonus;

    public Manager() {
    }

    public Manager(String name, double salary, double bonus) {
        super(name,salary);
        this.bonus = bonus;
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

    public double getAnnual(){
        return super.getSalary()+this.bonus;
    }
}
