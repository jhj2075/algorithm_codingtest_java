package Baekjoon.Do_it;

import java.util.Scanner;


// 그래프 - 여행 계획 짜기
public class Main_51_1976 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int k = sc.nextInt();
                if (k == 1){
                    arr[find(j)] = arr[find(i)];
                }
            }
        }
        int[] plan = new int[m];
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }
        boolean isYes = true;
        for (int i = 1; i < m; i++) {
            if (find(plan[i]) != find(plan[i-1]))
                isYes = false;
        }
        if (isYes)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    public static int find(int n){
        if (arr[n] == n){
            return n;
        }
        else {
            return arr[n] = find(arr[n]);
        }
    }
}