package Baekjoon.Do_it;

import java.util.*;


// 그래프 - 최단 경로 구하기 (다익스트라)
public class Main_56_1753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int s = sc.nextInt();
        ArrayList<Edge1>[] arr = new ArrayList[V+1];
        for (int i = 1; i <= V; i++){
            arr[i] = new ArrayList<Edge1>();
        }
        for (int i = 1; i <= E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(new Edge1(v, w));
        }

        // 다익스트라
        int[] result = new int[V+1];
        for (int i = 0; i <= V; i++){
            result[i] = Integer.MAX_VALUE;
        }
        result[s] = 0;

        PriorityQueue<Edge1> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        queue.offer(new Edge1(s, 0));
        while (!queue.isEmpty()){
            Edge1 now = queue.poll();
            int now_v = now.vertex;
            if (visited[now_v])
                continue;
            visited[now_v] = true;

            for (int i = 0; i < arr[now_v].size(); i++){
                Edge1 tmp = arr[now_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if(result[next] > result[now_v] + value){
                    result[next] = value + result[now_v];
                    queue.add(new Edge1(next, result[next]));
                }
            }

        }
        for (int i = 1; i <= V; i++){
            if (visited[i]){
                System.out.println(result[i]);
            }
            else
                System.out.println("INF");
        }
    }
}
class Edge1 implements Comparable<Edge1>{
    int vertex;
    int value;

    Edge1(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Edge1 e) { // 작은 값을 우선순위 높게
        if (this.value > e.value) return 1;
        else return -1;
    }
}

// 여기는 내가 푼 풀이. 답은 구할 수 있으나 메모리 초과가 남
// 큐에 value를 넣지 않아서 효율적이지 않고
// inhanced for문에서 모든 노드를 큐에 추가하고
// visited 배열을 사용하지 않아서 이미 처리된 노드가 다시 큐에 들어감

//import java.util.*;
//
//public class Baekjoon.Do_it.Main_56_1753 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int V = sc.nextInt();
//        int E = sc.nextInt();
//        int s = sc.nextInt();
//        ArrayList<Baekjoon.Do_it.Edge1>[] arr = new ArrayList[V+1];
//        for (int i = 1; i <= V; i++){
//            arr[i] = new ArrayList<Baekjoon.Do_it.Edge1>();
//        }
//        for (int i = 1; i <= E; i++){
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            int w = sc.nextInt();
//            arr[u].add(new Baekjoon.Do_it.Edge1(v, w));
//        }
//
//        // 다익스트라
//        int[] result = new int[V+1];
//        for (int i = 1; i <= V; i++){
//            result[i] = Integer.MAX_VALUE;
//        }
//        result[s] = 0;
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(s);
//        while (!queue.isEmpty()){
//            int now = queue.poll();
//            for (Baekjoon.Do_it.Edge1 i : arr[now]){
//                result[i.vertex] = Math.min(result[i.vertex], result[now] + i.value);
//                queue.add(i.vertex);
//            }
//
//        }
//        for (int i = 1; i <= V; i++){
//            if (result[i] == Integer.MAX_VALUE){
//                System.out.println("INF");
//            }
//            else
//                System.out.println(result[i]);
//        }
//    }
//}
//class Baekjoon.Do_it.Edge1 implements Comparable<Baekjoon.Do_it.Edge1>{
//    int vertex;
//    int value;
//
//    Baekjoon.Do_it.Edge1(int vertex, int value){
//        this.vertex = vertex;
//        this.value = value;
//    }
//
//    @Override
//    public int compareTo(Baekjoon.Do_it.Edge1 o) {
//        if (this.value > o.value) return 1;
//        else return -1;
//    }
//}
