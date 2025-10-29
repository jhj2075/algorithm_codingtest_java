package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// BFS - 나이트의 이동
public class Main_7562 {
    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int start_x = sc.nextInt();
            int start_y = sc.nextInt();
            int target_x = sc.nextInt();
            int target_y = sc.nextInt();

            if (start_x == target_x && start_y == target_y) {
                System.out.println(0);
                continue;
            }

            int[][] dist = new int[l][l];
            boolean[][] visited = new boolean[l][l];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start_x, start_y});
            visited[start_x][start_y] = true;
            dist[start_x][start_y] = 0;

            while (!queue.isEmpty()){
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];

                for (int j = 0; j < 8; j++) {
                    int now_x = x + dx[j];
                    int now_y = y + dy[j];

                    if (now_x >= 0 && now_y >= 0 && now_x < l && now_y < l){
                        if (!visited[now_x][now_y]){
                            visited[now_x][now_y] = true;
                            dist[now_x][now_y] = dist[x][y] + 1;
                            queue.add(new int[]{now_x, now_y});

                            if (now_x == target_x && now_y == target_y){
                                System.out.println(dist[now_x][now_y]);
                                queue.clear();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
