package Programmers.JAVA.P_영어끝말잇기;

import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 1;
        while (true){
            if (a % 2 == 1) a++;
            if (b % 2 == 1) b++;
            a /= 2;
            b /= 2;

            if (a == b)
                break;

            cnt++;
        }

        return cnt;
    }
}
