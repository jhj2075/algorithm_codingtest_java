package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15657 {
    static int n;
    static int m;
    static int[] arr;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ans = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        backtracking(0);

    }
    static void backtracking(int depth){
        if (depth == m){
            for (int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth == 0 || arr[i] >= ans[depth - 1]){
                ans[depth] = arr[i];
                backtracking(depth + 1);
            }
        }
    }
}
