package Baekjoon.sw_maestro_prepare;

import java.util.Scanner;

public class Main_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = n;
        for (int i = 0; i < n; i++){
            int[] arr = new int[26];
            String string = sc.next();
            char[] st = string.toCharArray();
            for (int j = 1; j < st.length; j++){
                if (st[j-1] == st[j]){
                    arr[st[j] - 'a']++;
                    arr[st[j] - 'a']++;
                }
                else {
                    if (arr[st[j] - 'a'] > 0) {
                        cnt--;
                        break;
                    }
                    arr[st[j-1] - 'a']++;
                    arr[st[j] - 'a']++;
                }
            }
        }
        System.out.println(cnt);
    }
}
