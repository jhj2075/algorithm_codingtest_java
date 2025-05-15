package Baekjoon;

import java.util.Scanner;


// 탐색 - 랜선 자르기
public class Main_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] arr = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextLong();
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long ans = 0;
        while (left <= right){
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < k; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt >= n){
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
