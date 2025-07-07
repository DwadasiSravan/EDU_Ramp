import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
    static void linearSearch(int[] arr, int x){
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x) {
                index = i;
                System.out.println("Entered number is available at the index: " + index);
                break;
            }
        }
        if(index == -1){
            System.out.println("Entered number is not available.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length: ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter the numbers: ");
        for(int i = 0; i < len; i++){
            int num = sc.nextInt();
            arr[i] = num;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the number to be searched: ");
        int n = sc.nextInt();
        linearSearch(arr, n);

    }
}
