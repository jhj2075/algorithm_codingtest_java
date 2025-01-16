import java.util.Scanner;


// 정수론 - 소수 구하기
public class Main_37_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 2; i <= n; i++){
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++){
            if (arr[i] == 0){
                continue;
            }

            for (int j = 2; i*j <= n; j++){
                arr[i*j] = 0;
            }
        }
        for (int i = m; i <= n; i++){
            if (arr[i] != 0)
                System.out.println(arr[i]);
        }
    }
}
