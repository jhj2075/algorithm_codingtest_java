import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


// 그래프 - 최소 신장 트리 구하기
public class Main_64_1197 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge3> queue = new PriorityQueue<>();
        for (int i = 1; i <= e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            queue.add(new Edge3(a, b, c));
        }
        parent = new int[v+1];
        for (int i = 1; i <= v; i++){
            parent[i] = i;
        }
        int edgeCnt = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Edge3 now = queue.poll();
            if (find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.value;
                edgeCnt++;
                if (edgeCnt == e-1){
                    break;
                }
            }
        }
        System.out.println(result);
    }
    public static void union(int a, int b){
        int aParent = find(a);
        int bParent = find(b);
        parent[bParent] = aParent;
    }
    public static int find(int n){
        if (parent[n] == n)
            return n;
        else {
            int p = parent[n];
            int prime = find(p);
            parent[n] = prime;
            return prime;
        }
    }
}
class Edge3 implements Comparable<Edge3>{
    int s, e, value;

    Edge3(int s, int e, int value){
        this.s = s;
        this.e = e;
        this.value = value;
    }

    @Override
    public int compareTo(Edge3 o) {
        return this.value < o.value ? -1 : 1;
    }
}