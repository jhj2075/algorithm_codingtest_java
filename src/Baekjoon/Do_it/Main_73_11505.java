package Baekjoon.Do_it;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 트리 - 구간 곱 구하기 (세그먼트 트리)
// 문제에 1_000_000_007로 나눈 나머지 구하라고 써있으니 그대로 해야함. int 끼리 곱셈이 int 범위를 넘어갈 수 있으니 생각해서 캐스팅해줘야함
public class Main_73_11505 {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        // 2^k >= N을 만족하는 k에 대해 2^k * 2 크기의 배열 만들기
        int k = 0;
        while ((int)Math.pow(2, k) < N){
            k++;
        }
        int[] arr = new int[(int)Math.pow(2, k) * 2];
        for (int i = 0; i < N; i++) {
            arr[(int)Math.pow(2, k) + i] = sc.nextInt();
        }
        // 구간곱으로 나머지 배열 채우기
        for (int i = (int)Math.pow(2, k) - 1; i >= 1; i--) {
            arr[i] = (int)(((long)arr[i * 2] * arr[i * 2 + 1]) % MOD);
        }

        // a == 1 => 업데이트, a == 2 => 구간곱 출력하기
        for (int i = 0; i < M + K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            b = b + (int)Math.pow(2, k) - 1;

            // 업데이트
            if (a == 1){
                arr[b] = c;
                while (b > 1){
                    // b가 왼쪽 노드인 경우
                    if (b % 2 == 0){
                        arr[b / 2] = (int)(((long)arr[b] * arr[b+1]) % MOD);
                    }
                    // b가 오른쪽 노드인 경우
                    else {
                        arr[b / 2] = (int)(((long)arr[b - 1] * arr[b]) % MOD);
                    }
                    b = b / 2;
                }
            }
            // 구간곱 출력
            else {
                c = c + (int)Math.pow(2, k) - 1;
                Queue<Integer> queue = new LinkedList<>();
                while (b <= c) {
                    if (b % 2 == 1)
                        queue.add(arr[b]);
                    if (c % 2 == 0)
                        queue.add(arr[c]);
                    b = (b + 1) / 2;
                    c = (c - 1) / 2;
                }
                int ans = 1;
                while (!queue.isEmpty()){
                    ans = (int)(((long)ans * queue.poll()) % MOD);
                }
                System.out.println(ans);
            }
        }
    }
}
