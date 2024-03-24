package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class p12919 {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String T = st.nextToken();

        if (judge(S, T)) {
            bw.write("1");
        }
        else {
            bw.write("0");
        }
        bw.flush();
    }

    public static boolean judge(String S, String T) {
        if (S.equals(T)) {
            return true;
        }
        StringBuilder builder = new StringBuilder(S);
        String reversedS = builder.reverse().toString();
        if (T.contains(S) || T.contains(reversedS)) {
            String S_B = S + "B";
            StringBuilder builder_B = new StringBuilder(S_B);
            S_B = builder_B.reverse().toString();

            String S_A = S + "A";

            if (judge(S_A, T)|| judge(S_B, T)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

}
