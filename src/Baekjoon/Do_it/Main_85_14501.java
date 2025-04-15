package Baekjoon.Do_it;

import java.util.Scanner;


// 동적 계획법 - 퇴사 준비하기
public class Main_85_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        for (int i = 1; i <= n; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        // D[i]는 i일부터 퇴사까지 금액이 최대로 되게 상담을 했을 때의 수입
        int[] D = new int[n+2];
        for (int i = n; i > 0; i--) {
            // 오늘 일자 + 걸리는 시간이 퇴사일을 넘기는 경우
            if (i + T[i] > n + 1){
                D[i] = D[i+1]; // 어짜피 그 일은 못하므로 [다음 날부터 퇴사까지의 수입]과 같음
            }
            // 퇴사 안에 일을 할 수 있는 경우
            else {
                D[i] = Math.max(D[i+1], D[i + T[i]] + P[i]); // [다음 날부터 퇴사까지의 수입]과 [이 일을 끝낸 날부터 퇴사까지의 수입] + [이 일의 수입] 중 큰 값을 고름
            }
        }
        System.out.println(D[1]);
    }
}
