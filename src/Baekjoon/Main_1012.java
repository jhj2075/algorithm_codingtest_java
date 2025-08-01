package Baekjoon;

import java.util.Scanner;


// DFS - 유기농 배추
public class Main_1012 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int M;
    static int N;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            int K = sc.nextInt();
            arr = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                arr[Y][X] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] != 0 && !visited[j][k]){
                        DFS(j, k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static void DFS(int a, int b){
        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int x = b + dx[i];
            int y = a + dy[i];
            if (x < M && y < N && x >= 0 && y >= 0){
                if (arr[y][x] != 0 && !visited[y][x]){
                    DFS(y, x);
                }
            }
        }
    }
}
