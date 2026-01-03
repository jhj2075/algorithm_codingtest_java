package Baekjoon;

import java.util.Scanner;


// DFS - 적록색약
public class Main_10026 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static boolean[][] visited;
    static char[][] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N][N];
        input = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                input[i][j] = s.charAt(j);
            }
        }

        // 정상
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

        // 적록색약
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] == 'R'){
                    input[i][j] = 'G';
                }
            }
        }
        visited = new boolean[N][N];
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        char tmp = input[x][y];

        for (int i = 0; i < 4; i++) {
            int now_x = x + dx[i];
            int now_y = y + dy[i];

            if (now_x >= 0 && now_y >= 0 && now_x < N && now_y < N){
                if (!visited[now_x][now_y] && input[now_x][now_y] == tmp){
                    dfs(now_x, now_y);
                }
            }
        }
    }
}
