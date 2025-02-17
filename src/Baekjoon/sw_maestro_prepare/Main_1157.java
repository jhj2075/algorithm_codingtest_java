package Baekjoon.sw_maestro_prepare;

import java.util.Scanner;

public class Main_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next().toUpperCase();
        char[] st = string.toCharArray();
        int[] arr = new int[26];
        int max = 0;
        char result = ' ';
        for (int i = 0; i < st.length; i++){
            arr[st[i] - 65]++;
        }
        for (int i = 0; i < 26; i++){
            if (max > 0 && max == arr[i]){
                result = '?';
            }
            else if (max < arr[i]){
                max = arr[i];
                result = (char) (i + 65);
            }
        }
        System.out.println(result);

    }
}
