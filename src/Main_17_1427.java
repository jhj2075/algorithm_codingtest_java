import java.util.Scanner;


// 정렬 - 내림차순으로 자릿수 정렬하기 (Arrays.sort 하면 바로 풀 수 있지만 선택정렬으로 구현)
public class Main_17_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            arr[i] = Integer.parseInt(str.substring(i, i+1)); // substring에 인자가 1개면 인자의 인덱스의 뒤를 다 가져오는 것이고, 인자가 2개면 앞 인자부터 뒤 인자 인덱스까지
        }

        for (int i = 0; i < str.length() - 1; i++){
            int max_index = i;
            for (int j = i; j < str.length(); j++){
                if (arr[max_index] < arr[j]){
                    max_index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max_index];
            arr[max_index] = tmp;
        }

        for (int i = 0; i < str.length(); i++){
            System.out.print(arr[i]);
        }
    }
}
