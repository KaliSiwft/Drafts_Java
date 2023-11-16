package Phone;

public class Main {
    public static void main(String[] args) {
        Phone[] phones = new Phone[3];
        Phone p1 = new Phone("huawei",5999,"米色白");
        Phone p2 = new Phone("vivo",2000,"曜石黑");
        Phone p3 = new Phone("oppo",1000,"翡冷翠");
        phones[0] = p1;
        phones[1] = p2;
        phones[2] = p3;
        double all = phones[0].getPrice() + phones[1].getPrice() + phones[2].getPrice();
        System.out.printf("average = %.1f",all/phones.length);
    }
}
