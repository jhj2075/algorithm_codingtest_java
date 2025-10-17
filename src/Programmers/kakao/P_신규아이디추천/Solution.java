package Programmers.kakao.P_신규아이디추천;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1.
        new_id = new_id.toLowerCase();

        // 2.
        for (int i = 0; i < new_id.length(); i++){
            char c = new_id.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.')
                answer += c;
        }

        // 3.
        while (answer.indexOf("..") != -1){
            answer = answer.replace("..", ".");
        }

        // 4.
        if (!answer.isEmpty() && answer.charAt(0) == '.'){
            answer = answer.substring(1);
        }
        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.'){
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5.
        if (answer.isEmpty()){
            answer = "a";
        }

        // 6.
        if (answer.length() >= 16){
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.'){
                answer = answer.substring(0, 14);
            }
        }

        // 7.
        if (answer.length() <= 2){
            for (int i = answer.length() - 1; i < 2; i++){
                char c = answer.charAt(i);
                answer += c;
            }
        }

        return answer;
    }
}