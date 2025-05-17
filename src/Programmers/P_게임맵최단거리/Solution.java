package Programmers.P_게임맵최단거리;
import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] visited;
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        System.out.println(n);
        visited = new boolean[maps.length][maps[0].length];
        BFS(maps, 0, 0);
        if (maps[n-1][m-1] == 1)
            return -1;
        return maps[n-1][m-1];
    }

    public void BFS(int[][] maps, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < maps.length && y < maps[0].length){
                    if (!visited[x][y] && maps[x][y] != 0){
                        visited[x][y] = true;
                        maps[x][y] = maps[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}