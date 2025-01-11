import java.util.Scanner;


// 배열과 리스트 - 숫자의 합 구하기
public class Main_1_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String num = sc.next();
        char[] arr = num.toCharArray();
        int sum = 0;

        for (int i = 0; i < N; i++){
            sum += arr[i] - '0';
        }

        System.out.println(sum);
    }
}
