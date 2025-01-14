import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 탐색 - 친구 관계 파악하기
public class Main_25_13023 {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    public static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n]; // 23번과 다르게 이 문제에서는 0번 노드도 있으므로 0부터
        visited = new boolean[n];
        arrive = false;
        for (int i = 0; i < n; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        for (int i = 0; i < n; i++){
            DFS(i, 1);
            if (arrive)
                break;
        }
        if (arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }
    public static void DFS(int now, int depth){
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[now] = true;
        for (int i : arr[now]){
            if (!visited[i]){
                DFS(i, depth + 1);
            }
        }
        visited[now] = false; // 이 문제는 경로가 이어지다 끊어졌을 때 그 경로의 노드를 모두 사용하지 못하는 것이 아니라 다른 경로에서도 그 노드를 사용해야하므로 초기화해줘야함
    }
}
