package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_15686 {

    static int n;
    static int m;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;
    static boolean[] open;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][n];

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 1){
                    home.add(new Point(i, j));
                }
                else if (arr[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];
        ans = Integer.MAX_VALUE;

        back(0, 0);
        System.out.println(ans);
    }

    static void back(int start, int cnt){
        if (cnt == m){
            int res = 0;

            for (int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int d = Math.abs(home.get(i).x - chicken.get(j).x) +
                                Math.abs(home.get(i).y - chicken.get(j).y);

                        tmp = Math.min(tmp, d);
                    }
                }
                res += tmp;
            }
            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            back(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
