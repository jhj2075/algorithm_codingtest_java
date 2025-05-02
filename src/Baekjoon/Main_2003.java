package Baekjoon;

import java.util.Scanner;


// 투 포인터 - 수들의 합 2
public class Main_2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int i = 0;
        int j = 0;
        int sum = arr[0];
        int cnt = 0;
        while (j < n){
            if (sum == m){
                cnt++;
                j++;
                sum += arr[j];
            }
            else if (sum > m){
                sum -= arr[i];
                i++;
            }
            else {
                j++;
                if (j > n-1)
                    break;
                sum += arr[j];
            }
        }
        System.out.println(cnt);
    }
}
