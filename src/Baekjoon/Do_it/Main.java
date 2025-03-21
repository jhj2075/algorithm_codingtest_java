package Baekjoon.Do_it;

import java.util.Scanner;

public class Main {
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
                    arr[knowPeople[i]] = knowPeople[0];
                }
            }

            for (int i = 0; i < m; i++) {
                int p = sc.nextInt();
                if (p > 1) {
                    int[] participants = new int[p];
                    boolean isThatParty = false;
                    for (int j = 0; j < p; j++) {
                        participants[j] = sc.nextInt();
                        if (arr[participants[j]] == knowPeople[0]){
                            isThatParty = true;
                        }
                    }
                    // participants에 들어 있는 애 중에 knowPeople에 들어 있는 애가 하나라도 있으면 participants에 있는 애들 모두 union
                    if (isThatParty){
                        int root = participants[0];
                        for (int j = 1; j < p; j++) {
                            arr[participants[j]] = root;
                        }
                    }
                }
                else {
                    sc.nextInt();
                }
            }
            // arr 순회하면서 knowPeople[0]가 아닌 애들 세기
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[i] != arr[knowPeople[0]])
                    cnt++;
            }
            System.out.println(cnt);
        }

    }
}
