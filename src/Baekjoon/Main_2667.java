package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


// DFS - 단지번호붙이기
public class Main_2667 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int roomCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = tmp[j] - 48;
            }
        }

        int cnt = 0;
        ArrayList<Integer> room = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0 && !visited[i][j]){
                    roomCnt = 0;
                    DFS(i, j);
                    room.add(roomCnt + 1);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

        Collections.sort(room);
        for (int i = 0; i < cnt; i++) {
            System.out.println(room.get(i));
        }
    }

    static void DFS(int a, int b){
        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int x = b + dx[i];
            int y = a + dy[i];
            if (x >= 0 && y >= 0 && x < N && y < N){
                if (arr[y][x] != 0 && !visited[y][x]){
                    roomCnt++;
                    DFS(y, x);
                }
            }
        }
    }
}
