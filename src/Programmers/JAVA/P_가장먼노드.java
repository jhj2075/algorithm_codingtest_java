package Programmers.JAVA;
import java.util.*;

public class P_가장먼노드 {
    class Solution {

        boolean[] visited;
        List<Integer> list = new ArrayList<>();

        public int solution(int n, int[][] edge) {

            visited = new boolean[edge.length];

            List<Node>[] arr = new ArrayList[edge.length];
            for(int i = 0; i < edge.length; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i = 0; i < edge.length; i++){

                int s = edge[i][0];
                int e = edge[i][1];

                arr[s].add(new Node(e, 0));
                arr[e].add(new Node(s, 0));
            }

            bfs(arr);

            int max = 0;
            for (int v : list){
                max = Math.max(max, v);
            }

            int cnt = 0;
            for (int v : list){
                if(v == max) cnt++;
            }

            return cnt;

        }

        void bfs(List<Node>[] arr){
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(1, 0));
            visited[1] = true;

            while(!q.isEmpty()){
                Node now = q.poll();
                int nowNum = now.n;
                int nowValue = now.v;

                for (Node node : arr[nowNum]){
                    if(!visited[node.n]){
                        q.add(new Node(node.n, nowValue + 1));
                        visited[node.n] = true;
                        list.add(nowValue + 1);

                    }
                }
            }
        }
    }

    class Node{
        int n, v;

        Node(int n, int v){
            this.n = n;
            this.v = v;
        }
    }
}
