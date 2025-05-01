package Baekjoon.Do_it;

import java.util.Scanner;


// 기하 - 선분을 그룹으로 나누기
public class Main_99_2162 {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = -1;
        }

        int[][] line = new int[n+1][4];
        for (int i = 1; i <= n; i++) {
            line[i][0] = sc.nextInt();
            line[i][1] = sc.nextInt();
            line[i][2] = sc.nextInt();
            line[i][3] = sc.nextInt();
            // 이전에 저장돼 있는 선분과 교차 여부 확인
            for (int j = 1; j < i; j++) {
                if (isCross(line[i][0], line[i][1], line[i][2], line[i][3], line[j][0], line[j][1], line[j][2], line[j][3])){
                    union(i, j);
                }
            }
        }

        int groupCnt = 0;
        int groupLineCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] < 0) {
                groupCnt++;
                groupLineCnt = Math.min(groupLineCnt, parent[i]);
            }
        }
        System.out.println(groupCnt);
        System.out.println(-groupLineCnt);

    }

    public static int find(int i){
        if (parent[i] < 0)
            return i;

        return parent[i] = find(parent[i]);
    }

    public static void union(int i, int j){
        int p = find(i);
        int q = find(j);

        if (p == q)
            return;

        parent[p] += parent[q];
        parent[q] = p;
    }

    public static int CCW(long x1, long y1, long x2, long y2, long x3, long y3){
        long ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (ccw > 0)
            return 1;
        else if (ccw < 0)
            return -1;
        return 0;
    }

    public static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        int abc = CCW(x1, y1, x2, y2, x3, y3);
        int abd = CCW(x1, y1, x2, y2, x4, y4);
        int cda = CCW(x3, y3, x4, y4, x1, y1);
        int cdb = CCW(x3, y3, x4, y4, x2, y2);

        // 선분이 일직선 상에 있는 경우
        if (abc * abd == 0 && cda * cdb == 0){
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        }
        else if (abc * abd <= 0 && cda * cdb <= 0){
            return true;
        }
        return false;
    }

    public static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        if (Math.max(x1, x2) >= Math.min(x3, x4) && Math.max(x3, x4) >= Math.min(x1, x2)
                && Math.max(y1, y2) >= Math.min(y3, y4) && Math.max(y3, y4) >= Math.min(y1, y2))
            return true;
        return false;
    }
}
