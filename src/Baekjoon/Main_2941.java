package Baekjoon;

import java.util.Scanner;

public class Main_2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] st = sc.next().toCharArray();

        int p = 0;
        int cnt = 0;
        while (p < st.length){
            if (p < st.length - 1 && ((st[p] == 'c' && st[p+1] == '=')
                    || (st[p] == 'c' && st[p+1] == '-')
                    || (st[p] == 'd' && st[p+1] == '-')
                    || (st[p] == 'l' && st[p+1] == 'j')
                    || (st[p] == 'n' && st[p+1] == 'j')
                    || (st[p] == 's' && st[p+1] == '=')
                    || (st[p] == 'z' && st[p+1] == '='))){
                p++;
            }
            else if (p < st.length - 2 && (st[p] == 'd' && st[p+1] == 'z' && st[p+2] == '=')){
                p += 2;
            }

            cnt++;
            p++;
        }
        System.out.println(cnt);
    }
}
