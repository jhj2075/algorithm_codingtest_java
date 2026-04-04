package Programmers.P_전력망을둘로나누기;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // wires의 한 행씩 다 끊어서
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++){
            int[][] tmpWires = new int[wires.length-1][2];
            int idx = 0;

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                tmpWires[idx][0] = wires[j][0];
                tmpWires[idx][1] = wires[j][1];
                idx++;
            }

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            int cnt = 1;

            q.add(1);
            visited[1] = true;
            while (!q.isEmpty()){
                int now = q.poll();

                for (int j = 0; j < wires.length-1; j++){
                    int a = tmpWires[j][0];
                    int b = tmpWires[j][1];

                    // now와 연결된 다른 노드 방문
                    if (a == now && !visited[b]) {
                        q.add(b);
                        visited[b] = true;
                        cnt++;
                    } else if (b == now && !visited[a]) {
                        q.add(a);
                        visited[a] = true;
                        cnt++;
                    }
                }
            }
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
        }
        return min;
    }
}