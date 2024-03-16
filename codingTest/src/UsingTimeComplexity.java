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
}
