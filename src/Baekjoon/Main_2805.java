package Baekjoon;

import java.util.Scanner;


// 탐색 - 나무 자르기
public class Main_2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 1;
        int right = 2_000_000_000;
        int ans = 0;
        while (left <= right){
            int mid = (left + right) / 2;
            long sum = 0; // int 범위를 넘어갈 수 있으므로 long으로

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid){
                    sum += arr[i] - mid;
                }
            }

            if (sum >= m){
                ans = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
