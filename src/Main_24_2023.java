import java.util.Scanner;


// 탐색 - 신기한 소수 찾기
public class Main_24_2023 {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }
    public static void DFS(int num, int jarisu){
        // 자리수가 입력 받은 값과 같고 소수이면 출력
        if (jarisu == n){
            if (isPrime(num)){
                System.out.println(num);
            }
            return;
        }
        for (int i = 1; i < 10; i++){
            // 짝수이면 볼 필요 없음
            if (i % 2 == 0){
                continue;
            }
            // 애초에 main 함수에서 한 자리 수는 소수만 넘겨줬으니, 자리 수를 높였을 때 소수인지 판별해 소수라면 DFS를 재귀적으로 돌림
            if (isPrime(num * 10 + i)){
                DFS(num * 10 + i, jarisu + 1);
            }
        }
    }
    public static boolean isPrime(int num){
        for (int i = 2; i <= num / 2; i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
