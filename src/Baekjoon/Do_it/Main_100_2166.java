package Baekjoon.Do_it;

import java.util.Scanner;


// 기하 - 다각형의 넓이 구하기
public class Main_100_2166 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        // 다각형의 넓이는 ccw를 이용해서 원점과 다각형의 인접한 두 꼭짓점으로 만들어진 삼각형들의 넓이 합으로 구할 수 있음
        // 원점과 두 점의 ccw는 x1 * y2 - x2 * y1임
        double sum = 0;
        for (int i = 0; i < n; i++) {
            // 마지막 점과 첫 번째 점으로 만들어진 삼각형도 포함해야 하므로
            if (i == n-1){
                sum += arr[i][0] * arr[0][1] - arr[0][0] * arr[i][1];
            }
            else {
                sum += arr[i][0] * arr[i+1][1] - arr[i+1][0] * arr[i][1];
            }
        }
        String ans = String.format("%.1f", Math.abs(sum) / 2.0);
        System.out.println(ans);
    }
}
