import java.io.*;
import java.util.PriorityQueue;


// 스택과 큐 - 절댓값 힙 구현하기
public class Main_14_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs){
                return o1 > o2 ? 1 : -1; // 절대값이 같으면 음수의 우선 순위를 높임
            }
            else {
                return first_abs - second_abs; // 작은 수의 우선 순위를 높임
            }
        });

        BufferedWriter bt = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if (x == 0){
                if (queue.isEmpty()){
                    bt.write("0\n");
                }
                else bt.write(queue.poll() + "\n");
            }
            else {
                queue.add(x);
            }
        }
        bt.flush();

    }
}
