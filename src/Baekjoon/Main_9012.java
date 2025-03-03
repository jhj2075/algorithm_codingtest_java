package Baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


// 괄호 (문자열)
public class Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] arr = st.nextToken().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean isVPS = true;

            for (int j = 0; j < arr.length; j++) {
                if (arr[0] == ')'){
                    isVPS = false;
                    break;
                }
                if (arr[j] == ')'){
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    else {
                        isVPS = false;
                        break;
                    }
                }
                else {
                    stack.push(arr[j]);
                }
            }
            if (isVPS && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
