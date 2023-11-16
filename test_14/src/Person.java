public class Person {
    Main.main({1,2,3});
    private String name;
    private int age;
    private char gender;
    public boolean equals(Object b){
        if(this == b){
            return true;
        }
        return (b instanceof Person)
                && this.name.equals(((Person)b).name)
                && this.age == ((Person)b).age
                && this.gender == ((Person)b).gender;
    }
    public Person() {
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }
    public static void printStream(){
        System.out.println("~~~~~~~~~~");
    }
    public String toString() {
        return "Person{name = " + name + ", age = " + age + ", gender = " + gender + "}";
    }
}
