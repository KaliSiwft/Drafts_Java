package tes;

public class Main {
    public static void main(String[] args){
        Commodity[] commodities = new Commodity[3];
        Commodity commodity1 = new Commodity("111","鼠标",200,200);
        Commodity commodity2 = new Commodity("222","键盘",500,200);
        Commodity commodity3 = new Commodity("333","电脑",6000,200);
        commodities[0] = commodity1;
        commodities[1] = commodity2;
        commodities[2] = commodity3;
        System.out.println(commodities[0].toString());
        System.out.println(commodities[1].toString());
        System.out.println(commodities[2].toString());
    }
}
