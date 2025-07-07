import java.util.Arrays;

public class BubbleSortExample {

     static int[] sort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]) swap(arr, i, j);
            }
        }
         return arr;
     }
    static void swap(int[] arr, int i, int j){
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {49,5,11,9,956,1};
        System.out.println("Before bubble sort : " + Arrays.toString(arr));

        int[] arr1 = sort(arr);
        System.out.println("After bubble sort : " + Arrays.toString(arr1));
    }




}
