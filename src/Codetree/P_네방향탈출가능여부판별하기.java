package Codetree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// BFS
public class P_네방향탈출가능여부판별하기 {
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n][m];
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        BFS(n, m, grid);

        if (visited[n-1][m-1])
            System.out.println(1);
        else
            System.out.println(0);
    }

    static void BFS(int n, int m, int[][] grid){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()){
            Point now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0; i < 4; i++){
                int nextX = dx[i] + nowX;
                int nextY = dy[i] + nowY;
                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m){
                    if (!visited[nextX][nextY] && grid[nextX][nextY] == 1){
                        q.add(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
class Point {
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
