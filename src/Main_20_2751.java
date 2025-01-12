import java.io.*;


// 정렬 - 수 정렬하기 2
public class Main_20_2751 {
    public static int[] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        tmp = new int[n+1];
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, n);
        for (int i = 1; i <= n; i++){
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static void mergeSort(int s, int e){
        // 그룹 내의 값 수가 1개가 되면 재귀 중단
        if (e - s < 1)
            return;

        int m = (s + e) / 2;

        mergeSort(s, m);
        mergeSort(m + 1, e);

        // tmp에 arr 복사
        for (int i = s; i <= e; i++){
            tmp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;
        // merge하는 부분, 오름차순 정렬이므로 앞, 뒤 그룹 각각의 가장 앞 값 중 작은 값을 배열에 앞에서부터 차례대로 저장
        while (index1 <= m && index2 <= e){
            if (tmp[index1] > tmp[index2]){
                arr[k] = tmp[index2];
                index2++;
                k++;
            }
            else if (tmp[index1] < tmp[index2]){
                arr[k] = tmp[index1];
                index1++;
                k++;
            }
        }

        // 앞, 뒤 두 그룹 중 한 그룹에 남은 값이 있을 때 다 소모하기 위한 로직
        while(index1 <= m){
            arr[k] = tmp[index1];
            index1++;
            k++;
        }
        while (index2 <= e){
            arr[k] = tmp[index2];
            index2++;
            k++;
        }
    }
}
