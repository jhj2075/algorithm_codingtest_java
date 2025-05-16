package Baekjoon.Do_it;

import java.util.Scanner;


// 트리 - 문자열 집합 (트라이로 품)
public class Main_69_14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tNode root = new tNode();

        // 트라이 생성
        while (n > 0){
            String text = sc.next();
            tNode now = root;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null){
                    now.next[c - 'a'] = new tNode(); // 노드를 채우기만 함으로써 그 알파벳이 있다는 걸 알림
                }
                now = now.next[c - 'a'];

                if (i == text.length() - 1){
                    now.isEnd = true;
                }
            }
            n--;
        }

        int cnt = 0;
        // 트라이 탐색
        while (m > 0){
            String text = sc.next();
            tNode now = root;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null){
                    break;
                }
                now = now.next[c - 'a'];
                if (i == text.length() - 1 && now.isEnd)
                    cnt++;
            }
            m--;
        }
        System.out.println(cnt);
    }
}
class tNode{
    tNode[] next = new tNode[26];
    boolean isEnd;
}
