public class Main {
    public static void main(String[] args) {
        int arr1[] = new int[93];
        int  n = 0,k = 0;
        for(int i = 2; i < 100; i++){
            k=1;
            for(int j = 2; j< i /2;j++){
                if(i % j == 0){
                    k = 0;
                    break;
                }
            }
            if(k == 1)arr1[n++] = i;
        }

        //int[][] arr2 = new int[100][3];
        getAdd(arr1);

    }
        int [][]arr2 = new int[100][3];
        int x = 0, y = 0;
        for(int i=0;i<arr1.length-2;i++){
            for(int j=i+1;j<arr1.length;j++){
                int sum = arr1[i] + arr1[j];
                if(sum < 100){
                    arr2[x][y++] = arr1[i];
                    arr2[x][y++] = arr1[j];
                    arr2[x++][y] = sum;
                    y = 0;
                }
            }
        }
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[0].length;j++){
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
        return arr2;
    }
}