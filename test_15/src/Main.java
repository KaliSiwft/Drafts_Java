public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("张三",12,'男');
        Person p2 = new Person("张三",18,'女');
        Person p3 = new Person("张三",16,'女');
        Person[] arr = new Person[3];
        arr[1] = p1;
        arr[2] = p2;
        arr[0] = p3;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr.length-i;j++){
                if(arr[j].getAge()>arr[j+1].getAge()){
                    Person p = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = p;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

// public > default > protected > private
//private  本类
//protected  本类 子类
//default 本包
//public 不同包

