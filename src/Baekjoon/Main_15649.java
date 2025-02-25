package Baekjoon;

import java.util.Scanner;


// N과 M(1) (백트래킹)
public class Main_15649 {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];
        ans = new int[m];
        backtracking(0);
    }
    static void backtracking(int depth){
        if (depth == m){
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++){
            if (!visited[i] && (depth == 0 || ans[depth - 1] != i)){
                ans[depth] = i;
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
