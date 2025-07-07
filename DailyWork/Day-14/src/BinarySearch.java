import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static void binarySearch(int[] arr, int x){
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            int first = 0;
            int last = arr.length - 1;
            int mid = (first + last)/2;

            if(arr[mid] == x) {
                System.out.println("Entered number is available at the index: " + mid);
                index = mid;
                break;
            }
            if(x < arr[mid]) last = mid - 1;
            if(x > arr[mid]) first = mid + 1;
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
        binarySearch(arr, n);

    }
}
