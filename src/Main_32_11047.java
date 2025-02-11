import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 그리디 - 동전 개수의 최솟값 구하기
public class Main_32_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        int tmp = 0;
        int i = n-1;
        while (tmp != k){
            if (arr[i] > k || tmp + arr[i] > k){
                i--;
                continue;
            }
            tmp += arr[i];
            cnt++;
        }
        System.out.println(cnt);
    }
}
