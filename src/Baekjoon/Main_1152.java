package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 단어의 개수 (문자열)
public class Main_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(st.countTokens());
//        String string = br.readLine();
//        String[] st = string.trim().split(" ");
//        if (st[0].equals("")) System.out.println(st.length - 1);
//        else System.out.println(st.length);
    }
}
