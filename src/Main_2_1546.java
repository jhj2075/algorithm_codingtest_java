import java.util.Scanner;


// 배열과 리스트 - 평균 구하기
public class Main_2_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int M = 0;
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > M)
                M = arr[i];
        }
        double sum = 0;
        for (int i = 0; i < N; i++){
            sum += arr[i];
        }
        System.out.println(sum * 100 / M / N);

    }
}
