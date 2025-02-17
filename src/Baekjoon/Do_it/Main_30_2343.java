package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 탐색 - 블루레이 만들기
public class Main_30_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            if (start < arr[i]){
                start = arr[i];
            }
        }

        while (start <= end){
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++){
                if (sum + arr[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum = sum + arr[i];
            }
            if (sum != 0)
                cnt++;
            if (cnt > m)
                start = mid + 1;
            else
                end = mid - 1;
        }
        System.out.println(start);
    }
}
