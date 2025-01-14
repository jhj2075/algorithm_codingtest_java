import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


// 탐색 - 연결 요소의 개수 구하기
public class Main_23_11724 {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visited = new  boolean[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s); // 방향 없는 그래프이므로 두 노드 모두에 에지를 넣음
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                cnt++;
                DFS(i);
            }
        }
        System.out.println(cnt);
    }
    public static void DFS(int s){
        // 이미 방문한 노드이면 재귀 종료
        if (visited[s]){
            return;
        }

        visited[s] = true;
        // enhanced for문 arr[s] 안의 값들을 i에 하나씩 대입시켜 반복
        for (int i : arr[s]){
            if (visited[i] == false){
                DFS(i);
            }
        }
    }
}
