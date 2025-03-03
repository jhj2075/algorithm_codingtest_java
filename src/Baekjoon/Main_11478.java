package Baekjoon;

import java.util.HashSet;
import java.util.Scanner;


// 서로 다른 부분 문자열의 개수 (문자열)
public class Main_11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int cnt = 0;
        for (int i = 1; i <= st.length(); i++) {
            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < st.length(); j++) {
                // j 부터 i개를 잘라서 set에 넣어야함
                if (j + i <= st.length()) {
                    String sub = st.substring(j, j + i);
                    set.add(sub);
                }
            }
            cnt += set.size();
        }
        System.out.println(cnt);
    }
}
