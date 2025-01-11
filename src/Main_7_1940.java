import java.util.Arrays;
import java.util.Scanner;

// 투 포인터 - 주몽
public class Main_7_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int i = 0;
        int j = N - 1;
        int cnt = 0;

        for (int w = 0; w < N; w++){
            arr[w] = sc.nextInt();
        }

        Arrays.sort(arr);

        while (i < j){
            if (arr[i] + arr[j] == M){
                cnt++;
                i++;
                j--;
            }
            else if(arr[i] + arr[j] > M){
                j--;
            }
            else if (arr[i] + arr[j] < M) {
                i++;
            }
        }
        System.out.println(cnt);
    }
}
