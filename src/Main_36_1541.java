import java.util.Scanner;


// 그리디 - 최솟값을 만드는 괄호 배치 찾기
public class Main_36_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ex = sc.nextLine();
        String[] str = ex.split("-");

        int result = 0;
        for (int i = 0; i < str.length; i++){
            String[] plus = str[i].split("[+]");
            int sum = 0;
            for (int j = 0; j < plus.length; j++){
                sum += Integer.parseInt(plus[j]);
            }
            if (i == 0){
                result += sum;
            }
            else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}
