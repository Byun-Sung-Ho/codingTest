import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UsingTimeComplexity {
    //백준 2750
    public void sortingNumber(int count){
        int[] arr = new int[count];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        for (int val : arr) {
            System.out.println(val);
        }
    }

    //백준 11720
    public void sumNumbers(){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String numbers = scanner.next();
        char[] num = numbers.toCharArray();

        int sum=0;

        for (int i = 0; i < count; i++) {
            sum = sum + num[i] - '0';
        }
        System.out.println(sum);
    }

    
}
