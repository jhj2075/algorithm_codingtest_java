package Codetree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS
public class P_갈수있는곳들 {

    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        visited = new boolean[N][N];

        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            int startX = sc.nextInt();
            int startY = sc.nextInt();

            BFS(startX, startY, grid, N);
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void BFS(int startX, int startY, int[][] grid, int N){
        Queue<Point> q = new LinkedList<>();
        visited[startX-1][startY-1] = true;
        q.add(new Point(startX-1, startY-1));

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()){
            Point now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + nowX;
                int nextY = dy[i] + nowY;

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N){
                    if (!visited[nextX][nextY] && grid[nextX][nextY] == 0){
                        visited[nextX][nextY] = true;
                        q.add(new Point(nextX, nextY));
                    }
                }
            }
        }

    }
}
