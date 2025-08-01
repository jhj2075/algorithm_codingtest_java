package Baekjoon;

import java.util.Scanner;


// 그래프 - 섬의 개수
public class Main_4963 {
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int w;
    static int h;
    static boolean[][] visited;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            visited = new boolean[h][w];
            if (w == 0 && h == 0)
                break;

            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] != 0){
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }
    }
    static void DFS(int a, int b){
        visited[a][b] = true;

        for (int i = 0; i < 8; i++) {
            int x = b + dx[i];
            int y = a + dy[i];
            if (x < w && y < h && x >= 0 && y >= 0){
                if (!visited[y][x] && arr[y][x] != 0){
                    DFS(y, x);
                }
            }
        }
    }
}
