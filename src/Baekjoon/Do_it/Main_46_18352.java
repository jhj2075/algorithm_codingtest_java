package Baekjoon.Do_it;

import java.util.*;


// 그래프 - 특정 거리의 도시 찾기
public class Main_46_18352 {
    static int[] visited;
    static int distance;
    static int startCityNum;
    static ArrayList<Integer>[] arrayList;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityNum = sc.nextInt();
        int roadNum = sc.nextInt();
        distance = sc.nextInt();
        startCityNum = sc.nextInt();
        visited = new int[cityNum + 1];
        arrayList  = new ArrayList[cityNum + 1];
        cnt = 0;
        for (int i = 1; i <= cityNum; i++) {
            arrayList[i] = new ArrayList<>();
        }
        for (int i = 0; i < roadNum; i++) {
            int startCity = sc.nextInt();
            int endCity = sc.nextInt();
            arrayList[startCity].add(endCity);
        }
        Arrays.fill(visited, -1);

        BFS(startCityNum);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= cityNum; i++) {
            if (visited[i] == distance)
                list.add(i);
        }
        if (list.isEmpty()){
            System.out.println(-1);
        }
        else {
            Collections.sort(list);
            for (int i : list){
                System.out.println(i);
            }
        }
    }
    static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int i : arrayList[now]){
                if (visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
