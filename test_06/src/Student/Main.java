package Student;

public class Main {
    public static void main(String[] args) {
        Student[] st = new Student[3];
        Student st1 = new Student(1, "张三", 18);
        Student st2 = new Student(2, "李四", 19);
        Student st3 = new Student(3, "王五", 20);
        st[0] = st1;
        st[1] = st2;
        st[2] = st3;
        Student st4 = new Student(3, "王五", 20);

        public static boolean contains(int id, Student[] st){
            for (int i = 0; i < st.length; i++) {
                if (st[i].getId() == id)
                    return true;
            }
            return false;
        }
        boolean flag = contains(st4.getId(),st);
        if(flag){
            System.out.printf("error");
        }else {

        }
    }
}
