import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 탐색 - DFS와 BFS 프로그램
public class Main_26_1260 {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);
        }
        for (int i = 1; i <= n; i++){
            Collections.sort(arr[i]);
        }

        DFS(s);

        visited = new boolean[n+1];
        System.out.println();

        BFS(s);

    }
    public static void DFS(int num){
        if (visited[num])
            return;

        System.out.print(num + " ");
        visited[num] = true;
        for (int i : arr[num]){
            if (!visited[i]){
                DFS(i);
            }
        }
    }
    public static void BFS(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : arr[now]){
                if (!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }
    }
}
