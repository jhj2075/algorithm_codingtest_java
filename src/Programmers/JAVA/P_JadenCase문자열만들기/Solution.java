package Programmers.JAVA.P_JadenCase문자열만들기;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ", -1);
        String ans = "";
        for (int i = 0; i < str.length; i++){
            if (str[i].length() == 0) {
                ans += " ";
                continue;
            }
            char firstWord = str[i].toCharArray()[0];
            ans += Character.toUpperCase(firstWord) + str[i].substring(1).toLowerCase() + " ";
        }

        return ans.substring(0, ans.length() - 1);
    }
}