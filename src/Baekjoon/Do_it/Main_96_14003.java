package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 동적 계획법 - 가장 길게 증가하는 부분 수열 찾기
public class Main_96_14003 {
    static int n, maxLength;
    static int[] b = new int[1000001];
    static int[] arr = new int[1000001];
    static int[] d = new int[1000001];
    static int[] ans = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        d = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int index;
        b[++maxLength] = arr[1];
        d[1] = 1;
        for (int i = 2; i <= n; i++){
            if (b[maxLength] < arr[i]){
                b[++maxLength] = arr[i];
                d[i] = maxLength;
            }
            else {
                index = binarysearch(1, maxLength, arr[i]); // 바이너리 서치로 arr[i]가 현재 b 순열에서 몇 번째 수인지 그 index를 구함
                b[index] = arr[i]; // 그 번째 수 자리에 덮어 써버림
                d[i] = index; // dp 배열에는 arr[i]의 index를 기록
            }
        }
        System.out.println(maxLength);
        index = maxLength;
        int x = b[maxLength] + 1; // b 순열의 최댓값  + 1을 x로
        // arr의 맨 뒤에서부터 순열의 내 뒤의 값보다 작으면서 index가 같은 최초의 arr 값을 찾아냄
        for (int i = n; i >= 1; i--){
            if (d[i] == index && arr[i] < x){
                ans[index] = arr[i];
                x = arr[i];
                index--;
            }
        }
        for (int i = 1; i <= maxLength; i++){
            System.out.print(ans[i] + " ");
        }
    }
    static int binarysearch(int l, int r, int now){
        int mid;
        while (l < r){
            mid = (l + r) / 2;
            if (b[mid] < now)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}

// 스택 써서 해보려고 했는데 바이너리 서치 아니면 시간 초과나서 안된다고 함
//public class Baekjoon.Do_it.Main_96_14003 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n+1];
//        int[] d = new int[n+1];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 1; i <= n; i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        // 1 1 2 3 3 4 4 4 5 5
//        // arr 에서 바로 앞 값이 아니라 앞 순열의 최대값보다 지금 arr 배열의 수가 크면 길어 ++
//        // 순열 길이가 1이면 arr 다음 값이 작은 값이 나왔을 때 초기화?
//        // d[i] = d[i-1] + ?
//        // ?는 i 앞의 순열의 마지막 값보다 d[i]가 크면 +1, 아니면 +0 => 순열을 스택에 넣으면 되려나?
//        // 10 11 5 6 7 8 9
//        int cnt = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(arr[1]);
//        for (int i = 2; i <= n; i++){
//            if (arr[i] > stack.peek()){
//                stack.push(arr[i]);
//                cnt = 0;
//            }
//            else {
//                cnt++;
//                if (stack.size() == cnt){
//                    stack.clear();
//                    for (int j = cnt+1; j <= i; j++){
//                        stack.push(arr[j]);
//                    }
//                }
//            }
//        }
//        int s = stack.size();
//        System.out.println(stack.size());
//        int[] result = new int[stack.size()+1];
//        for (int i = stack.size(); i > 0; i--){
//            result[i] = stack.pop();
//        }
//        for (int i = 1; i <= s; i++){
//            System.out.print(result[i] + " ");
//        }
//    }
//}
