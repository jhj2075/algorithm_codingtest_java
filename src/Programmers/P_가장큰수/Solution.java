package Programmers.P_가장큰수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] answer = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            answer[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(answer, (o1,o2) -> (o2 + o1).compareTo(o1 + o2));

        if (answer[0].equals("0")){
            return "0";
        }

        return String.join("", answer);
    }
}