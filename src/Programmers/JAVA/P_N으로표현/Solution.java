package Programmers.JAVA.P_N으로표현;

import java.util.*;
class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }

    static public int solution(int N, int number) {
        if (N == number)
            return 1;
        // 최솟값이 1, 2, 3, ~, 8 까지 list 내부 set에 담음
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            list.add(new HashSet<>());
        }
        list.get(1).add(N); // 1인 경우는 자기 자신인 경우 하나.

        for (int i = 2; i <= 8; i++){
            Set<Integer> countSet = list.get(i);

            for (int j = 1; j < i; j++){
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i - j);

                for (int num1 : preSet){
                    for (int num2 : postSet){
                        countSet.add(num1 + num2);
                        countSet.add(num1 - num2);
                        countSet.add(num1 * num2);
                        if (num2 != 0)
                            countSet.add(num1 / num2);
                    }
                }
            }
            String tmp = "";
            for (int j = 0; j < i; j++){
                tmp += N;
            }
            countSet.add(Integer.parseInt(tmp));

            if (list.get(i).contains(number)){
                return i;
            }
        }

        return -1;
    }
}