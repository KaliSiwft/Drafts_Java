import java.sql.SQLOutput;
import java.util.Scanner;

public class Main{
    public static int[] arr1 = {1,3,5,7,8,10,12};
    public static int[] arr2 = {4,6,9,11};


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int week = 0,weekDay = 0;


        if(year < 1900){
            System.out.println("请输入大于或等于1900的年份");
        } else if (month < 1 || month >12) {
            System.out.println("请输入正确的月份");
        } else {
            int leaseDay = 0;
            int runYear = (int)testRunYear(year);

            for (int i = 1900; i < year; i++) {
                if (testRunYear(i) == 1) leaseDay += 366;
                else leaseDay += 365;
            }

            for (int i = 1; i < month; i++) {
                if (i == 2 && runYear == 1) leaseDay += 29;
                else if (i == 2 && runYear == 0) leaseDay += 28;
                for (int j = 0; j < arr1.length; j++) {
                    if (i == arr1[j]) {
                        leaseDay += 31;
                        break;
                    }
                }
                for (int j = 0; j < arr2.length; j++) {
                    if (i == arr1[j]) {
                        leaseDay += 30;
                        break;
                    }
                }
            }
            week = leaseDay % 7 + 1;
            System.out.println("==================================================");
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            int dayFromThatOn = Test(month,runYear);
            int n = week + 1;
            if( n == 8 ) n = 1;
            for(int i = 1;i<7;i++){
                if(i == week){
                    for(int j=0;j < week;j++){
                        System.out.print(" " + "\t");
                    }
                    break;
                }
            }
            for(int i=1;i<=dayFromThatOn;i++,n++){
                if( n == 8 ){
                    System.out.println();
                    n = 1;
                }
                System.out.print(i + "\t");
            }
            System.out.println();
            System.out.print("==================================================");
        }
    }

    public static int testRunYear(int year){
        if(year%4 == 0 && year%100 != 0 || year%400 ==0) return 1;
        else return 0;
    }

    public static int Test(int month,int runYear){
        if(month == 2){
            if(runYear == 0) return 28;
            else if(runYear == 1) return 29;
        }else {
            for(int i=0;i<arr1.length;i++)
                if(arr1[i] == month) return 31;
            for(int i=0;i<arr2.length;i++)
                if(arr2[i] == month) return 30;
        }
        return -1;
    }

}
