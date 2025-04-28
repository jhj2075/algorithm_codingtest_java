package Baekjoon.Do_it;

import java.util.Scanner;


// 기하 - 선분의 교차 여부 구하기
public class Main_98_17387 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long x2 = sc.nextLong();
        long y2 = sc.nextLong();
        long x3 = sc.nextLong();
        long y3 = sc.nextLong();
        long x4 = sc.nextLong();
        long y4 = sc.nextLong();

        int CCW_abc = ccw(x1, y1, x2, y2, x3, y3);
        int CCW_abd = ccw(x1, y1, x2, y2, x4, y4);
        int CCW_cda = ccw(x3, y3, x4, y4, x1, y1);
        int CCW_cdb = ccw(x3, y3, x4, y4, x2, y2);

        // CCW끼리 부호가 다르거나 둘 중 하나가 0인 경우
        if (CCW_abc * CCW_abd <= 0 && CCW_cda * CCW_cdb <= 0){
            // 두 선분이 일직선 상에 있는 경우
            if (CCW_abc == 0 && CCW_abd == 0) {
                // 한 선분의 최소 좌표값이 다른 선분의 최대 좌표값보다 크면 일직선 상에서 두 선분은 만나지 않음
                if (Math.max(x1, x2) < Math.min(x3, x4) || Math.max(x3, x4) < Math.min(x1, x2) || Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) {
                    System.out.println(0);
                } else
                    System.out.println(1);
            }
            // 일직선 상에 있지 않고 CCW끼리 부호가 다르면 무조건 교차함
            else
                System.out.println(1);
        }
        // CCW끼리 부호가 같으면 교차하지 않음
        else
            System.out.println(0);
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (ccw > 0)
            return 1;
        else if (ccw < 0)
            return -1;
        return 0;
        // ccw 끼리의 곱셈이 커지면 long 범위를 넘어가는 듯. 그래서 1, -1, 0으로 리턴
    }
}
