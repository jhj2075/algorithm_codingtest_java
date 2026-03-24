package Codetree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// BFS
public class P_K번최댓값으로이동하기 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int r;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;


        for (int i = 0; i < k; i++) {
            visited = new boolean[n][n];
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + r;
                int ny = dy[j] + c;

                if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                    min = Math.min(min, grid[nx][ny]);
                }
            }
            if (min > grid[r][c]) break;
            BFS(grid, n);
        }

        r++;
        c++;
        System.out.println(r + " " + c);
    }

    static void BFS(int[][] grid, int n){
        Queue<P> q = new LinkedList<>();
        q.add(new P(r, c, grid[r][c]));
        visited[r][c] = true;
        int v = grid[r][c];

        int maxV = 0;
        while (!q.isEmpty()){
            P now = q.poll();
            int cx = now.x;
            int cy = now.y;
            int cv = now.v;
            if (cv != v){
                maxV = Math.max(maxV, cv);
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;

                if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if (!visited[nx][ny] && v > grid[nx][ny]){
                        visited[nx][ny] = true;
                        q.add(new P(nx, ny, grid[nx][ny]));
                    }
                }
            }
        }
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] && grid[i][j] == maxV){
                    r = i;
                    c = j;
                    break outer;
                }
            }
        }
    }
}
class P{
    int x, y, v;

    public P(int x, int y, int v){
        this.x = x;
        this.y = y;
        this.v = v;
    }
}