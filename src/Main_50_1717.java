import java.util.Scanner;


// 그래프 - 집합 표현하기 (union-find)
public class Main_50_1717 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n+1];
        for (int i = 0; i <= n; i++){
            arr[i] = i;
        }
        for (int i = 0; i < m; i++){
            int c = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // union
            if (c == 0){
                int aPrime = find(a);
                int bPrime = find(b);
                arr[bPrime] = arr[aPrime];
            }
            // find
            else {
                if (find(a) == find(b)){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }
    public static int find(int n){
        if (arr[n] == n){
            return n;
        }
        else {
            int k = arr[n];
            int prime = find(k);
            arr[n] = prime;
            return prime;
        }
    }
}
