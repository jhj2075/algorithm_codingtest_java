import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 조합 - 순열의 순서 구하기
public class Main_81_1722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] f = new long[21];
        int[] s = new int[21];
        boolean[] visited = new boolean[21];
        f[0] = 1;
        for (int i = 1; i <= n; i++){
            f[i] = f[i-1] * i;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        if (q == 1){
            long k = Long.parseLong(st.nextToken());
            for (int i = 1; i <= n; i++){
                int cnt = 1;
                for (int j = 1; j <= n; j++){
                    if (visited[j]) // 사용된 숫자인지 판별
                        continue;
                    // 팩토리얼 배열의 한 칸 앞 숫자의 배수만큼 증가시키며 k가 작거나 같을 때
                    // 이전 배수만큼 k를 빼서 k번째를 하락 시킴
                    // 4자리 수의 3번째 순열을 구하려면 1 은 제일 먼저 맨 앞 확정시키고 그 다음 자리가 3인데, 1 3 까지 확정되면 그 다음 남은 2 4 중에는 확정으로 2 4가 순서대로
                    // 나와야하므로 k를 1로 만들어서 2 4 중에는 1번째 순열을 나오게 하는 거
                    if (k <= cnt * f[n-i]){
                        k -= f[n-i] * (cnt - 1);
                        s[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= n; i++){
                System.out.print(s[i] + " ");
            }
        }
        else if (q == 2){
            long k = 1;
            for (int i = 1; i <= n; i++){
                s[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < s[i]; j++){
                    if (visited[j] == false){
                        cnt++;
                    }
                }
                k += cnt * f[n-i];
                visited[s[i]] = true;
            }
            System.out.println(k);
        }
    }
}
