package Baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


// 정렬 - 좌표 압축
public class Main_18870 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Data(sc.nextLong(), i);
        }

        Arrays.sort(arr, Comparator.comparingLong(o -> o.value));
        int cnt = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i+1].value != arr[i].value){
                arr[i].value = cnt;
                cnt++;
            }
            else {
                arr[i].value = cnt;
            }
        }
        arr[n-1].value = cnt;

        Arrays.sort(arr, Comparator.comparingInt(o -> o.order));

        // sout으로 하면 시간 초과 남
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(arr[i].value + " ");
        }
        bw.flush();
        bw.close();

        // 이렇게 하면 시간초과 남. 이중 반복문은 절대 안되는 듯. 답은 맞음
//        int[] tmp = new int[n];
//        for (int i = 0; i < n; i++) {
//            tmp[i] = arr[i];
//        }
//        Arrays.sort(tmp);
//
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0){
//                    if (tmp[i] == arr[j]){
//                        arr[j] = 0;
//                        break;
//                    }
//                }
//                else if (tmp[i-1] != tmp[i]){
//                    if (tmp[i] == arr[j]){
//                        cnt++;
//                        arr[j] = cnt;
//                        break;
//                    }
//                }
//                else {
//                    if (tmp[i] == arr[j]){
//                        arr[j] = cnt;
//                        break;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }
}
class Data{
    long value;
    int order;

    Data(long value, int order){
        this.value = value;
        this.order = order;
    }
}