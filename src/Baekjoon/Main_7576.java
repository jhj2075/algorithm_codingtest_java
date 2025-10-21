package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// DFS - 토마토
public class Main_7576 {
    static int M;
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Tomato> queue;
    static int[][] arr;

    static class Tomato{
        int x, y, day;

        Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        queue = new LinkedList<>();
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int n = sc.nextInt();
                arr[i][j] = n;
                if (n == 1){
                    queue.add(new Tomato(j, i, 0));
                }
            }
        }

        bfs();
    }

    static void bfs(){
        int day = 0;

        while (!queue.isEmpty()){
            Tomato now = queue.poll();
            day = now.day;

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (x >= 0 && y >= 0 && x < M && y < N){
                    if (arr[y][x] == 0) {
                        arr[y][x] = 1;
                        queue.add(new Tomato(x, y, day + 1));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day);
    }
}
