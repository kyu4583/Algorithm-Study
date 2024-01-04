package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1459 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long answer = 0;

        if (s < 2 * w) {
            long z = (x<y)?x:y;
            x -= z;
            y -= z;
            answer += z * s;
            long t = x + y;
            if (s < w) {
                answer += t / 2 * (s * 2);
                t %= 2;
            }
            answer += t * w;
            bw.write(Long.toString(answer));
        } else {
            answer += (x + y) * w;
            bw.write(Long.toString(answer));
        }
    }
}
