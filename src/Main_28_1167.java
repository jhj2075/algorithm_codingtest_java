import java.util.*;


// 탐색 - 트리의 지름 구하기
public class Main_28_1167 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < n; i++){
            int s = sc.nextInt();
            while (true){
                int e = sc.nextInt();
                if (e == -1)
                    break;
                int v = sc.nextInt();
                arr[s].add(new Edge(e, v));
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(1); // 일단 1부터 BFS 한 번 돎

        int max = 1;
        for (int i = 2; i <= n; i++){
            if (distance[max] < distance[i]){
                max = i;
            }
        }

        distance = new int[n+1];
        visited = new boolean[n+1];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[n]);
    }
    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for (Edge i : arr[now]){
                int e = i.edge;
                int v = i.value;
                if (!visited[e]){
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
}
class Edge {
    int edge;
    int value;

    public Edge(int edge, int value){
        this.edge = edge;
        this.value = value;
    }
}
