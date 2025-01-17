import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 그래프 - 게임 개발하기 (위상정렬 이용)
public class Main_54_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = new ArrayList<Integer>();
        }
        int[] time = new int[n+1];
        int[] d = new int[n+1];
        for (int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            while (true){
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1)
                    break;
                arr[pre].add(i);
                d[i]++;
            }
        }
        // 위상정렬
        int[] result = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            if (d[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int i : arr[now]){
                d[i]--;
                result[i] = Math.max(result[i], result[now] + time[now]);
                if (d[i] == 0){
                    queue.offer(i);
                }
            }
        }
        for (int i = 1; i <= n; i++){
            System.out.println(time[i] + result[i]);
        }
    }
}
