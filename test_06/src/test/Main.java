package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Car[] cars = new Car[3];
        Car car1 = new Car(sc.next(),sc.nextDouble(),sc.next());
        Car car2 = new Car(sc.next(),sc.nextDouble(),sc.next());
        Car car3 = new Car(sc.next(),sc.nextDouble(),sc.next());
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        System.out.println(cars[0].toString());
        System.out.println(cars[1].toString());
        System.out.println(cars[2].toString());
    }
}
