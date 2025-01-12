import java.io.*;
import java.util.StringTokenizer;


// 정렬 - 버블 소트 프로그램 2 (Main_20 이랑 똑같은데 swap 횟수를 세는 로직 한 줄만 추가한 것)
public class Main_21_1517 {
    public static int[] arr, tmp;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        tmp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, n);
        System.out.println(result);
    }

    public static void mergeSort(int s, int e){
        if (e - s < 1)
            return;

        int m = (s + e) / 2;
        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++){
            tmp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e){
            if (tmp[index1] > tmp[index2]){
                arr[k] = tmp[index2];
                k++;
                index2++;
                result += index2 - k;
            }
            else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }

        while (index1 <= m){
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e){
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
