package Baekjoon.Do_it;

import java.util.Scanner;


// 조합 - 조약돌 꺼내기
public class Main_80_13251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] color = new int[m];
        int stoneCnt = 0;
        for (int i = 0; i < m; i++) {
            color[i] = sc.nextInt();
            stoneCnt += color[i];
        }
        int k = sc.nextInt();

        double probability = 0;
        for (int i = 0; i < m; i++) {
            double tmp = (double) color[i] / stoneCnt;
            for (int j = 1; j < k; j++) {
                tmp *= (double) (color[i]-j) / (stoneCnt-j);
            }
            probability += tmp;
        }
        System.out.println(probability);
    }
}
