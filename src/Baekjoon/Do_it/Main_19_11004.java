package Baekjoon.Do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 정렬 - k번째 수 구하기
public class Main_19_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, n - 1, k - 1);
        System.out.println(arr[k-1]);
    }
    public static void quickSort(int[] arr, int s, int e, int k){
        if (s < e){
            int pivot = partition(arr, s, e);
            if (pivot == k){ // pivot이 k와 같으면 재귀 중단
                return;
            }
            else if (k < pivot) {
                quickSort(arr, s, pivot - 1, k); // pivot 왼쪽 그룹 재귀적으로 퀵소트 수행
            }
            else if (pivot < k){
                quickSort(arr, pivot + 1, e, k); // pivot 오른쪽 그룹 재귀적으로 퀵소트 수행
            }
        }
    }
    public static int partition(int [] arr, int s, int e){
        if (s + 1 == e){
            if (arr[s] > arr[e]) {
                swap(arr, s, e);
            }
            return e;
        }

        int m = (s + e) / 2;
        swap(arr, s, m);
        int pivot = arr[s];
        int i = s + 1;
        int j = e;
        // pivot보다 큰 값은 오른쪽으로 몰고 작은 값은 왼쪽으로 몰기 (왼쪽, 오른쪽 각각 그룹에서의 정렬은 중요하지 않음)
        // i와 j가 만날 때까지 수행
        while (i <= j){
            while (j >= s + 1 && arr[j] > pivot) {
                j--;
            }
            while (i <= e && arr[i] < pivot){
                i++;
            }
            if (i <= j){
                swap(arr, i++, j--);
            }
        }

        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
