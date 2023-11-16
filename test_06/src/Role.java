import java.util.Random;

public class Role {
    private String name;
    private int blood;
    public Role() {
    }

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return blood
     */
    public int getBlood() {
        return blood;
    }

    /**
     * 设置
     * @param blood
     */
    public void setBlood(int blood) {
        this.blood = blood;
    }

    void Attack(Role someone){
        Random r = new Random();
        int hurt = r.nextInt(20) + 1;
        int remain_blood = someone.getBlood() - hurt;
        remain_blood = remain_blood < 0 ? 0 : remain_blood;
        someone.setBlood(remain_blood);
        System.out.println(getName() + "向" + someone.getName() + "挥了挥拳头，造成了" + hurt + "伤害，" + someone.getName() + "还剩下" + someone.getBlood() +"血量");
    }


}
