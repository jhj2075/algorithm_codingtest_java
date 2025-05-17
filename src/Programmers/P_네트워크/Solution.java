package Programmers.P_네트워크;

import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<Integer>[] list;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i != j){
                    if (computers[i][j] == 1){
                        list[i].add(j);
                        list[j].add(i);
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                cnt++;
                DFS(i);
            }
        }
        return cnt;
    }

    public void DFS(int num){
        if (visited[num]){
            return;
        }

        visited[num] = true;
        for (int i : list[num]){
            if (!visited[i]){
                DFS(i);
            }
        }
    }
}