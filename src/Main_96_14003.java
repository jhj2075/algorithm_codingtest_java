import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_96_14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] d = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1 1 2 3 3 4 4 4 5 5
        // arr 에서 바로 앞 값이 아니라 앞 순열의 최대값보다 지금 arr 배열의 수가 크면 길어 ++
        // 순열 길이가 1이면 arr 다음 값이 작은 값이 나왔을 때 초기화?
        // d[i] = d[i-1] + ?
        // ?는 i 앞의 순열의 마지막 값보다 d[i]가 크면 +1, 아니면 +0 => 순열을 스택에 넣으면 되려나?
        // 10 11 5 6 7 8 9
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[1]);
        for (int i = 2; i <= n; i++){
            if (arr[i] > stack.peek()){
                stack.push(arr[i]);
                cnt = 0;
            }
            else {
                cnt++;
                if (stack.size() == cnt){
                    stack.clear();
                    for (int j = cnt+1; j <= i; j++){
                        stack.push(arr[j]);
                    }
                }
            }
        }
        int s = stack.size();
        System.out.println(stack.size());
        int[] result = new int[stack.size()+1];
        for (int i = stack.size(); i > 0; i--){
            result[i] = stack.pop();
        }
        for (int i = 1; i <= s; i++){
            System.out.print(result[i] + " ");
        }
    }
}
