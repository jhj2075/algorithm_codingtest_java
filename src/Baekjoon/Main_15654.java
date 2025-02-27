package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15654 {
    static int n;
    static int m;
    static int[] input;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
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
            if (!visited[i] && (depth == 0 || ans[depth - 1] != input[i-1])){
                ans[depth] = input[i-1];
                visited[i] = true;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
