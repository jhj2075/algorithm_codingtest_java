import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// 스택과 큐 - 카드 게임
public class Main_13_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue= new LinkedList<>();

        for (int i = 1; i <= n; i++){
            queue.add(i);
        }

        while (queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
