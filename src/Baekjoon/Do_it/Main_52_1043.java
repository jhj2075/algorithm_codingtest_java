package Baekjoon.Do_it;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 그래프 - 거짓말쟁이가 되긴 싫어
public class Main_52_1043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int knowNum = sc.nextInt();
        if (knowNum == 0) {
            // 입력 소비를 위한 로직
            for (int i = 0; i < m; i++) {
                int p = sc.nextInt();
                for (int j = 0; j < p; j++) {
                    sc.nextInt();
                }
            }
            System.out.println(m);
        }
        else {
            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = i;
            }
            int[] knowPeople = new int[knowNum];
            for (int i = 0; i < knowNum; i++) {
                knowPeople[i] = sc.nextInt();
                // knowPeople들은 다 union
                if (i > 0){
                    int aRoot = find(arr, knowPeople[i]);
                    int bRoot = find(arr, knowPeople[0]);
                    if (aRoot != bRoot)
                        arr[aRoot] = bRoot;
                }
            }

            List<int[]> parties = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int p = sc.nextInt();
                if (p > 1) {
                    int[] participants = new int[p];
                    for (int j = 0; j < p; j++) {
                        participants[j] = sc.nextInt();
                    }
                    parties.add(participants);
                    // participants에 들어 있는 애 중에 knowPeople에 들어 있는 애가 하나라도 있으면 participants에 있는 애들 모두 union
                    for (int j = 1; j < p; j++) {
                        int aRoot = find(arr, participants[j]);
                        int bRoot = find(arr, participants[0]);
                        if (aRoot != bRoot) arr[aRoot] = bRoot;
                    }

                }
                else {
                    int[] participants = new int[1];
                    participants[0] = sc.nextInt();
                    parties.add(participants);
                }
            }
            // 여기가 문제였네 arr는 사람 수이지 파티 수가 아니잖아 파티 수를 세야지 사람 수를 세면 안됨
            int cnt = 0;
            int truthRoot = find(arr, knowPeople[0]);
            for (int[] participants : parties){
                boolean isThatParty = true;
                for (int i : participants){
                    if (find(arr, i) == truthRoot) {
                        isThatParty = false;
                        break;
                    }
                }
                if (isThatParty) cnt++;
            }
            System.out.println(cnt);
        }
    }
    public static int find(int[] arr, int x) {
        if (arr[x] == x) return x;
        return arr[x] = find(arr, arr[x]);
    }
}
