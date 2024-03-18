import java.util.Arrays;
import java.util.Scanner;

public class SectionSum {
    //백준 11659
    public void ItoJSum(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int count = scanner.nextInt();
        int[] arrs = new int[size];
        int[] sums = new int[size+1];
        sums[0] = 0;

        for (int index = 0; index < size; index++) {
            arrs[index] = scanner.nextInt();
        }

        for (int index = 1; index < size+1; index++) {
            sums[index] = sums[index-1] + arrs[index-1];
        }

        for (int index = 0; index < count; index++) {
            int i=scanner.nextInt();
            int j=scanner.nextInt();

            System.out.println(sums[j] - sums[i-1]);
        }
    }
}
