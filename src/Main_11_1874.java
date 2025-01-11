import java.util.Scanner;
import java.util.Stack;


// 스택과 큐 - 스택으로 오름차순 수열 만들기
public class Main_11_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer(); // 중간에 NO가 되는 경우가 있기 때문에 push, pop 때마다 출력할 수 없음, 그래서 버퍼에 저장해놓고 나중에 한 번에 출력하는 식으로
        for (int i = 0; i < n; i++){
            if (arr[i] >= num){
                while (arr[i] >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else if (arr[i] < num) {
                int k = stack.pop();
                if (k > arr[i]){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else bf.append("-\n");
            }
        }
        if (result){
            System.out.println(bf.toString());
        }
    }
}
