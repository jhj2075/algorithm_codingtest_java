import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 정렬 - 버블 소트 프로그램 1
public class Main_16_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] A = new mData[n];
        for (int i = 0; i < n; i++){
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < n; i++){
            if (max < A[i].index - i){
                max = A[i].index - i;
            }
        }

        System.out.println(max+1);
    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}
