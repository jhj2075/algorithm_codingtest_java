package Programmers.JAVA.P_괄호회전하기;

import java.util.*;

class Solution {
  public int solution(String s) {

    Stack<Character> stack;

    int cnt = 0;
    for(int k = 0; k < s.length(); k++){
      char[] charArr = s.toCharArray();
      char tmp = charArr[0];
      for(int i = 1; i < s.length(); i++){
        charArr[i-1] = charArr[i];
      }
      charArr[s.length()-1] = tmp;
      s = String.valueOf(charArr);

      stack = new Stack<>();
      stack.push(s.charAt(0));

      for(int i = 1; i < s.length(); i++){
        if(stack.isEmpty()){
          stack.push(s.charAt(i));
          continue;
        }

        char peekC = stack.peek();
        char cur = s.charAt(i);
        if ((peekC == '[' && cur == ']')
            || (peekC == '{' && cur == '}')
            || (peekC == '(' && cur == ')')){
          stack.pop();
        }
        else {
          stack.push(s.charAt(i));

        }
      }

      if(stack.isEmpty())
        cnt++;
    }

    return cnt;

  }
}
