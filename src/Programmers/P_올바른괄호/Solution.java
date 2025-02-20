package Programmers.P_올바른괄호;

import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        if (arr[0] == ')')
            return false;

        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++){
            if (arr[i] == ')'){
                if (!stack.isEmpty())
                    stack.pop();
                else return false;
            }
            else {
                stack.push(arr[i]);
            }
        }

        if (stack.size() > 0)
            return false;
        else return true;
    }
}
