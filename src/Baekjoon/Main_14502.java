package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// DFS, BFS - 연구소
public class Main_14502 {

    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int ans = 0;

    static class Node{
        int x, y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int depth){
        if (depth == 3){
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2){
                    queue.add(new Node(j, i));
                }
            }
        }

        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        while (!queue.isEmpty()){
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (x >= 0 && y >= 0 && x < M && y < N){
                    if (tmp[y][x] == 0){
                        tmp[y][x] = 2;
                        queue.add(new Node(x, y));
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0){
                    sum++;
                }
            }
        }

        ans = Math.max(ans, sum);
    }
}
