import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 트리 - 구간 합 구하기 3 (세그먼트 트리)
public class Main_71_2042 {
    public static long[] tree;
    public static int arrLength;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // 2^k >= n 인 k 구해서 배열 크기 구하기
        int height = 0;
        int length = n;
        while (length != 0){
            length /= 2;
            height++;
        }
        arrLength = (int) Math.pow(2, height+1);
        // 반복문에 이렇게 Math.pow 쓰면 속도가 엄청 느려지는 듯!
//        for (int i = 1; i < n; i++){
//            if (Math.pow(2, i) > n || Math.pow(2, i) == n){
//                arrLength = (int)Math.pow(2, i) * 2;
//                break;
//            }
//        }
        // 세그먼트 트리 만들기
        tree = new long[arrLength+1];
        for (int i = 0; i < n; i++){
            tree[arrLength/2 + i] = Long.parseLong(br.readLine());
        }
        for (int i = arrLength/2 - 1; i > 0; i--){
            tree[i] = tree[i*2] + tree[i*2 + 1];
        }
        // 질의 답하기
        for (int i = 1; i <= m+k; i++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1){
                update(b, c);
            }
            else if (a == 2){
                System.out.println(getSum(arrLength/2 + b - 1, (int) (arrLength/2 + c - 1)));
            }
            else return;
        }
    }
    public static void update(int b, long c){
        int i = arrLength/2 + b - 1;
        long d = c - tree[i];
        while (i > 0){
            tree[i] += d;
            i /= 2;
        }
    }
    public static long getSum(int s, int e){
        long partSum = 0;
        while (s <= e){
            if (s % 2 == 1){
                partSum += tree[s];
                s++;
            }
            if (e % 2 == 0){
                partSum += tree[e];
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partSum;
    }
}
