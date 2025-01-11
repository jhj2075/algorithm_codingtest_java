import java.io.*;
import java.util.Stack;


// 스택과 큐 - 오큰수 구하기
public class Main_12_17298 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in); // Scanner 쓰면 자꾸 시간 초과 난다. 이제 그냥 BufferedReader 쓰자.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int [] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int k = stack.pop();
                result[k] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int k = stack.pop();
            result[k] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
//            System.out.print(result[i] + " "); // sout도 시간 초과 때문에 안쓰는게 좋을듯
            bw.write(result[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
