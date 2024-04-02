import java.io.*;
import java.util.*;


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

    //백준 11660
    public void PlaneSum(){
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int count = scanner.nextInt();

        int[][] arrs = new int[arraySize][arraySize];
        int[][] sums = new int[arraySize+1][arraySize+1];

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                arrs[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i < arraySize+1; i++) {
            for (int j = 1; j < arraySize+1; j++) {
                sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + arrs[i-1][j-1];
            }
        }

        for (int i = 0; i < count; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            System.out.println(sums[x2][y2] - sums[x2][y1-1] - sums[x1-1][y2] + sums[x1-1][y1-1]);
        }
    }
    // 백준 10986
    public void RestSum(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        long res=0;
        long[] sums = new long[N];
        long[] rests = new long[M];

        sums[0] = scanner.nextInt();

        for (int i = 1; i < N; i++) {
            sums[i] = sums[i-1] + scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int rest = (int)(sums[i] % M);
            if (rest == 0) {
                res++;
            }

            rests[rest]++;
        }

        for (int i = 0; i < M; i++) {
            if (rests[i] > 1) {
                res = res + (rests[i] * (rests[i] - 1) / 2);
            }
        }

        System.out.println(res);
    }

    public void ContinuousSerialNaturalNumberSum(){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] numArr = new int[N];
        int res=0;
        int startIndex=0;
        int endIndex=0;

        for (int i = 1; i <= numArr.length; i++) {
            numArr[i-1] = i;
        }

        int sum = numArr[startIndex];
        while (endIndex != numArr.length - 1) {
            System.out.println(sum);
            if (sum == N){
                res++;
                endIndex++;
                sum = sum + numArr[endIndex];
            }
            else if (sum>N) {
                sum = sum - numArr[startIndex];
                startIndex++;
            }else {
                endIndex++;
                sum = sum + numArr[endIndex];
            }
        }
        res++;
        System.out.println(res);
    }

    public void AdjacentNaturalNumberSum(){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] numArr = new int[N];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = scanner.nextInt();
        }
        Arrays.sort(numArr);

        int startIndex=0;
        int endIndex=numArr.length-1;
        int sum=0;
        int res=0;
        while (startIndex != endIndex) {
            sum = numArr[startIndex] + numArr[endIndex];
            if (sum == M) {
                res++;
                startIndex++;
            } else if (sum < M){
                startIndex++;
            }
            else {
                endIndex--;
            }
        }
        System.out.println(res);
    }

    //백준 1253
    public void FindGoodNumber(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int res = 0;

        long[] numArr = new long[size];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = scanner.nextInt();
        }
        Arrays.sort(numArr);

        for (int i = 0; i < size; i++) {
            long target = numArr[i];

            int si=0;
            int ei=size-1;

            while (si < ei) {
                if (numArr[si] + numArr[ei] == target) {
                    if (si!=i && ei!=i) {
                        res++;
                        break;
                    } else if (si == i) {
                        si++;
                    }else {
                        ei--;
                    }
                } else if (numArr[si] + numArr[ei] < target) {
                    si++;
                }else {
                    ei--;
                }
            }
        }

        System.out.println(res);
    }

    //백준 12891
    public void DNApassword(){
        Scanner scanner = new Scanner(System.in);

        int totalSize = scanner.nextInt();
        int partSize = scanner.nextInt();

        char[] DNA = new char[totalSize];
        DNA = scanner.next().toCharArray();
        int A = scanner.nextInt();
        int C = scanner.nextInt();
        int G = scanner.nextInt();
        int T = scanner.nextInt();

        int cA=0;
        int cC=0;
        int cG=0;
        int cT=0;

        int res=0;

        for (int j = 0; j < partSize; j++) {
            switch (DNA[j]){
                case 'A':
                    cA++;
                    break;
                case 'C':
                    cC++;
                    break;
                case 'G':
                    cG++;
                    break;
                default:
                    cT++;
                    break;
            }
        }
        if (cA>=A && cG>=G && cC>=C && cT>=T){
            res++;
        }

        for (int i = 1; i < DNA.length-partSize+1; i++) {
            switch (DNA[i-1]){
                case 'A':
                    cA--;
                    break;
                case 'C':
                    cC--;
                    break;
                case 'G':
                    cG--;
                    break;
                default:
                    cT--;
                    break;
            }

            switch (DNA[i+partSize-1]){
                case 'A':
                    cA++;
                    break;
                case 'C':
                    cC++;
                    break;
                case 'G':
                    cG++;
                    break;
                default:
                    cT++;
                    break;
            }


            if (cA>=A && cG>=G && cC>=C && cT>=T){
                res++;
            }
        }
        System.out.println(res);
    }

    //백준 11003
    public void findMinV1(){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int slideWindowSize = scanner.nextInt();

        Long[] arr = new Long[N];
        for (int i = 0; i<arr.length;i++){
            arr[i] = scanner.nextLong();
        }

        Long min = arr[0];
        System.out.print(min);
        System.out.print(' ');
        for (int i=1; i<slideWindowSize;i++){
            if (arr[i]<min){
                min = arr[i];
            }
            System.out.print(min);
            System.out.print(' ');
        }


        for(int i=1; i<N-2*slideWindowSize;i++){
            System.out.print('b');
            Long min1 = arr[i];
            for (int j=0;j<slideWindowSize;j++){
                if (arr[i]<min1){
                    min1 = arr[i];
                }
            }
            System.out.print(min1);
            System.out.print(' ');
        }

        int si=N-slideWindowSize+1;
        Long min2 = arr[si];
        for (int i=si; i<N;i++){
            System.out.print('c');
            if (arr[i]<min2){
                min2 = arr[i];
            }
            System.out.print(min2);
            System.out.print(' ');
        }

    }
    //백준 11003
    public void findMinV2() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int slideWindowSize = scanner.nextInt();
        int[] arr = new int[N];
        Deque<Node> deq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            while(!deq.isEmpty() && deq.getLast().value > arr[i]){
                deq.removeLast();
            }
            deq.addLast(new Node(i, arr[i]));

            if (deq.getFirst().index<=i-slideWindowSize){
                deq.removeFirst();
            }

            System.out.print(deq.getFirst().value + " ");
        }
    }
    //백준 11003
    public void findMinV3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int slideWindowSize = Integer.parseInt(st.nextToken());

        Deque<Node> deq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while(!deq.isEmpty() && deq.getLast().value > now){
                deq.removeLast();
            }
            deq.addLast(new Node(i, now));

            if (deq.getFirst().index<=i-slideWindowSize){
                deq.removeFirst();
            }

            bw.write(deq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    //백준 1874

}
