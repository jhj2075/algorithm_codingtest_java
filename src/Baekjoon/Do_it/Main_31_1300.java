package Baekjoon.Do_it;

import java.util.Scanner;


// 탐색 - 배열에서 k번째 수 찾기
public class Main_31_1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ans = 0;
        long start = 1;
        long end = k;

        while (start <= end){
            long middle = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= n; i++){
                cnt += Math.min(middle / i, n);
            }

            if (cnt < k) {
                start = middle + 1;
            }
            else {
               end = middle - 1;
               ans = middle;
            }
        }
        System.out.println(ans);
// 이렇게 하면 메모리 초과
//        int[] arr = new int[n*n];
//        int w = 0;
//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j <= n; j++){
//                arr[w] = i * j;
//                w++;
//            }
//        }
//        Arrays.sort(arr);
//
//        System.out.println(arr[k-1]);
    }
}
