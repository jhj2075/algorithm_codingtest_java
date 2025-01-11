import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


// 슬라이딩 윈도우 - 최솟값 찾기
public class Main_10_11003 {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();

        for (int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());

            // 덱의 마지막 노드의 값이 들어가려는 값보다 크면 즉, 최솟값이 될 수 없으면 dequeue
            // dequeue 된 후에도 그 다음 마지막 노드도 확인해줘야하므로 덱이 비거나 마지막 노드의 값이 작을 때까지 반복
            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));

            // 윈도우를 오른쪽으로 슬라이딩.
            // 즉, 덱의 맨 앞 노드의 인덱스가 이제 들어가려는 노드 인덱스 - 윈도우 크기보다 작거나 같으면 dequeue
            if (mydeque.getFirst().index <= i - L){
               mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
