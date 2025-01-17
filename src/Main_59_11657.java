import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 그래프 - 타임머신으로 빨리 가기 (벨만-포드 알고리즘 / 내가 다 풀엇다!)
public class Main_59_11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge2>[] arr = new ArrayList[m+1];
        for (int i = 1; i <= m; i++){
            arr[i] = new ArrayList<Edge2>();
        }
        for (int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i].add(new Edge2(a, b, c));
        }
        long[] d = new long[n+1];
        for (int i = 0; i <= n; i++){
            d[i] = Long.MAX_VALUE;
        }
        d[1] = 0;
        boolean hasCycle = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (d[arr[j].get(0).s] != Long.MAX_VALUE && d[arr[j].get(0).s] + arr[j].get(0).value < d[arr[j].get(0).e]){
                    d[arr[j].get(0).e] = d[arr[j].get(0).s] + arr[j].get(0).value;
                    if (i == n)
                        hasCycle = true;
                }
            }
        }
        if (hasCycle){
            System.out.println("-1");
        }
        else {
            for (int i = 2; i <= n; i++){
                if (d[i] == Long.MAX_VALUE){
                    System.out.println("-1");
                }
                else
                    System.out.println(d[i]);
            }
        }
    }
}
class Edge2{
    int s, e, value;

    public Edge2(int s, int e, int value){
        this.s = s;
        this.e = e;
        this.value = value;
    }
}
