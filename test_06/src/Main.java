public class Main {
        public static void main(String[] args) {
                Role r1 = new Role("亚瑟", 100);
                Role r2 = new Role("妲己", 100);
                while (true) {
                        r1.Attack(r2);
                        if (r2.getBlood() == 0) {
                                System.out.println(r1.getName() + " K.O" + r2.getName());
                                break;
                        }
                        r2.Attack(r1);
                        if (r1.getBlood() == 0) {
                                System.out.println(r2.getName() + " K.O" + r1.getName());
                                break;
                        }
                }
        }
}