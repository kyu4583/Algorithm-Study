package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class p2141 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = 0;
        long rightA = 0;    //오버플로 ㅋㅋㅋㅋㅋㅋ
        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] chars = br.readLine().split(" ");
            int X = Integer.parseInt(chars[0]);
            int A = Integer.parseInt(chars[1]);
            rightA += A;
            map.add(List.of(X, A));
        }

        map.sort((o1, o2) -> o1.get(0).compareTo(o2.get(0)));

        long leftA = 0;
        for (int i = 0; ; i++) {
            int nowA = map.get(i).get(1);
            leftA += nowA;
            rightA -= nowA;
            if (leftA >= rightA) {
                bw.write(Integer.toString(map.get(i).get(0)));
                break;
            }
        }

        bw.flush();
    }
}