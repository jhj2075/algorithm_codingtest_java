package Baekjoon.Do_it;

import java.io.*;


// 정렬 - 수 정렬하기 3 (기수 정렬)
public class Main_22_10989 {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        radixSort(arr, 5); // 문제에서 수가 10000보다 작거나 같은 수라고 했으므로 자리수는 5를 넘지 않음
        for (int i = 0; i < n; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static void radixSort(int[] arr, int maxSize){
        int[] output = new int[arr.length];
        int jarisu = 1;
        int cnt = 0;

        while (cnt != maxSize){
            int[] bucket = new int[10];
            // 각 자리에 들어갈 개수 구해 bucket에 저장
            for (int i = 0; i < arr.length; i++){
                bucket[(arr[i] / jarisu) % 10]++;
            }
            // bucket을 합 배열로
            for (int i = 1; i < 10; i++){
                bucket[i] += bucket[i-1];
            }
            // 현재 bucket은 합 배열이므로 뒤에서 부터 순회하면 큰 수를 뒤에 넣고 -- 해서, 그 앞에 자리 수의 값이 같지만 더 작은 수를 놓을 수 있음
            for (int i = arr.length - 1; i >= 0; i--){
                output[bucket[(arr[i] / jarisu) % 10] - 1] = arr[i];
                bucket[(arr[i] / jarisu) % 10]--;
            }
            for (int i = 0; i < arr.length; i++){
                arr[i] = output[i];
            }
            jarisu = jarisu * 10;
            cnt++;
        }
    }
}
