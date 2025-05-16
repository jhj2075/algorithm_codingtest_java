package Baekjoon.Do_it;

import java.util.HashSet;
import java.util.Scanner;


// 트리 - 문자열 찾기 (트라이 문제인데, 그냥 hashset으로 품)
public class Main_69_14425_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(sc.next());
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (hashSet.contains(sc.next())){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    // 이렇게 풀면 시간초과
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        String[] S = new String[n];
//        for (int i = 0; i < n; i++) {
//            S[i] = sc.next();
//        }
//        String[] M = new String[m];
//        for (int i = 0; i < m; i++) {
//            M[i] = sc.next();
//        }
//        int cnt = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (M[i].equals(S[j])){
//                    cnt++;
//                    break;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
}
