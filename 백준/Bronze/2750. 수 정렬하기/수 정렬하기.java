import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int nums = sc.nextInt();
        int[] arr = new int[nums];
        
        for(int i=0; i<nums; i++){
            arr[i] = sc.nextInt();
        }
        
        bubbleSort(arr);
        
        for(int i=0; i<nums; i++){
            System.out.println(arr[i]);
        }
    }
    
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            //최적화를 위한 swap 변수
            boolean swap = false;
            
            for(int j=0; j<n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
        }
    }
}