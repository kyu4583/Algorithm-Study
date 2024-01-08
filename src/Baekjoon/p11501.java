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
            for (int j=0; j<N; j++) {
                action[j] = 0;
            }

            int start = 0;
            for (int max = maxIndex(lst, 0); max < lst.size(); max = maxIndex(lst, max + 1)) {
                for (int j = start; j < max; j++) {
                    action[j] = 1;
                }
                action[max] = 2;
                start = max + 1;
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

    public static int maxIndex(ArrayList<Integer> lst, int start) {
        if (start > lst.size() - 1) {
            return start;
        }
        int max = start;
        for (int i = start; i < lst.size(); i++) {
            if (lst.get(i) > lst.get(max)) {
                max = i;
            }
        }
        return max;
    }
}
