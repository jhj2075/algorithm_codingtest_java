package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;


// 정렬 - 단어 정렬
public class Main_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Word[] arr = new Word[n];
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            arr[i] = new Word(word, word.length());
        }
        Arrays.sort(arr);
        System.out.println(arr[0].word);
        for (int i = 1; i < n; i++) {
            if (!arr[i-1].word.equals(arr[i].word))
                System.out.println(arr[i].word);
        }
    }
}
class Word implements Comparable<Word> {
    String word;
    int length;

    Word(String word, int length){
        this.word = word;
        this.length = length;
    }

    @Override
    public int compareTo(Word o) {
        if (length == o.length)
            return word.compareTo(o.word);
        return length - o.length;
    }
}
