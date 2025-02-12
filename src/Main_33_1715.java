import java.util.PriorityQueue;
import java.util.Scanner;


// 그리디 - 카드 정렬하기
public class Main_33_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++){
            queue.add(sc.nextInt());
        }
        int sum = 0;
        while (queue.size() != 1){
            int a = queue.remove();
            int b = queue.remove();
            sum += a + b;
            queue.add(a + b);
        }
        System.out.println(sum);
    }
}
