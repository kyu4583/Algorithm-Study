package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class p11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> lst = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lst.add(Integer.parseInt(st.nextToken()));
            }

            int[] action = new int[N];
            for (int j = 0; j < N; j++) {
                action[j] = 0;
            }

            int max = N - 1;
            boolean peakIsExist = false;
            for (int j = N - 1; j >= 0; j--) {
                if (lst.get(j) > lst.get(max)) {
                    action[j] = 2;
                    max = j;
                    peakIsExist = true;
                } else if (peakIsExist) {
                    action[j] = 1;
                }
            }

            long answer = 0;    //오버플로
            int purchase = 0;
            for (int j = 0; j < N; j++) {
                if (action[j] == 1) {
                    answer -= lst.get(j);
                    purchase += 1;
                }
                if (action[j] == 2) {
                    answer += lst.get(j) * purchase;
                    purchase = 0;
                }
            }

            bw.write(Long.toString(answer) + "\n");
        }

        bw.flush();

    }
}
