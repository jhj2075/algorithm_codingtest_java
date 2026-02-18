package Baekjoon;

public class Main_4673 {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            String now = String.valueOf(i);

            int tmp = i;
            for (int j = 0; j < now.length(); j++) {
                tmp += now.toCharArray()[j] - '0';
            }

            if (tmp <= 10000) {
                arr[tmp] = true;
            }
        }

        for (int i = 1; i < 10000; i++) {
            if (!arr[i]){
                System.out.println(i);
            }
        }
    }
}
