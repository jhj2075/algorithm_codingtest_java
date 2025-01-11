import java.util.Scanner;


// 슬라이딩 윈도우 - DNA 비밀번호
public class Main_9_12891 {
    static int[] ACGT = new int[4];
    static int[] check = new int[4];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int p = sc.nextInt();
        int result = 0;
        String dna = sc.next();
        char[] arr = dna.toCharArray();

        for (int i = 0; i < 4; i++){
            ACGT[i] = sc.nextInt();
            if (ACGT[i] == 0)
                cnt++;
        }

        // 첫 윈도우는 그냥 계산
        for (int i = 0; i < p; i++){
            add(arr[i]);
        }
        if (cnt == 4)
            result++;

        // 윈도우 한 칸씩 슬라이딩하며 계산
        for (int i = p; i < s; i++){
            int j = i - p;

            add(arr[i]);
            remove(arr[j]);

            if (cnt == 4)
                result++;
        }
        System.out.println(result);
    }

    public static void add(char c){
        if (c == 'A'){
            check[0]++;
            if (check[0] == ACGT[0])
                cnt++;
        } else if (c == 'C') {
            check[1]++;
            if (check[1] == ACGT[1])
                cnt++;
        } else if (c == 'G') {
            check[2]++;
            if (check[2] == ACGT[2])
                cnt++;
        } else if (c == 'T') {
            check[3]++;
            if (check[3] == ACGT[3])
                cnt++;
        }
    }

    public static void remove(char c){
        if (c == 'A'){
            if (check[0] == ACGT[0])
                cnt--;
            check[0]--;
        } else if (c == 'C') {
            if (check[1] == ACGT[1])
                cnt--;
            check[1]--;
        } else if (c == 'G') {
            if (check[2] == ACGT[2])
                cnt--;
            check[2]--;
        } else if (c == 'T') {
            if (check[3] == ACGT[3])
                cnt--;
            check[3]--;
        }
    }
}
