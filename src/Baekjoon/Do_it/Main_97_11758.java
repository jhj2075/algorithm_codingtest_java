package Baekjoon.Do_it;

import java.util.Scanner;


// 기하 - 선분 방향 구하기
public class Main_97_11758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int CCW = (arr[0][0] * arr[1][1] + arr[1][0] * arr[2][1] + arr[2][0] * arr[0][1]) - (arr[1][0] * arr[0][1] + arr[2][0] * arr[1][1] + arr[0][0] * arr[2][1]);
        if (CCW < 0)
            System.out.println(-1);
        else if (CCW == 0)
            System.out.println(0);
        else
            System.out.println(1);
    }
}
