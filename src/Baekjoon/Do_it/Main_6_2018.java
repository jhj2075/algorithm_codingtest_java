package Baekjoon.Do_it;

import java.util.Scanner;


// 투 포인터 - 연속된 자연수의 합 구하기
public class Main_6_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long cnt = 1; // 자기 자신은 이미 센 걸로 판단
        long start_index = 1;
        long end_index = 1;
        long sum = 1;

        while (end_index != N){
            if (sum > N){
                sum -= start_index;
                start_index++;
            }
            else if (sum < N) {
                end_index++;
                sum += end_index;
            }
            else if (sum == N) {
                cnt++;
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(cnt);
    }
}
