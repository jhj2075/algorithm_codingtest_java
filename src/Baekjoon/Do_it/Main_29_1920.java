package Baekjoon.Do_it;

import java.util.Arrays;
import java.util.Scanner;


// 탐색 - 원하는 정수 찾기
public class Main_29_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] target = new int[m];
        for (int i = 0; i < m; i++){
            target[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++){
            int s = 0;
            int e = n-1;
            int mid = (s + e) / 2;
            int result = 0;
            while (s <= e) {
                if (arr[mid] == target[i]) {
                    result = 1;
                    break;
                } else if (arr[mid] < target[i]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
                mid = (s + e) / 2;
            }
            System.out.println(result);
        }
    }
}
