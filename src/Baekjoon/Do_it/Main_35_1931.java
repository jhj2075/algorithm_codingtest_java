package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 그리디 - 회의실 배정
public class Main_35_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Room[] rArr = new Room[n];

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rArr[i] = new Room(a, b);
        }
        Arrays.sort(rArr);
        int cnt = 1;
        int last = rArr[0].end;
        for (int i = 1; i < n; i++){
            if (rArr[i].start >= last){
                cnt++;
                last = rArr[i].end;
            }
        }
        System.out.println(cnt);

    }
}
class Room implements Comparable<Room>{
    int start, end;

    Room(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room o) {
        if (this.end == o.end){
            // 시작 시간과 종료 시간이 같은 회의도 카운트 해주려면 시작 시간에 대해서도 오름차순 정렬 해줘야 함
            // (2 2) (1 2) (2 3) 이렇게 주어졌을 때 1 2 -> 2 2 -> 2 3 순으로 3개 카운트 해줘야하므로
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}
