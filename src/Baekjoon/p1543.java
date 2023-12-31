package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1543 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String dividend = br.readLine();
        String divisor = br.readLine();
        String target = "";
        int answer = 0;

        for (int i = 0; i < dividend.length(); i++) {
            target += dividend.charAt(i);
            if (target.equals(divisor)) {
                answer += 1;
                target = "";
            }
            if (target.length() >= divisor.length()) {
                target = target.substring(1);
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();

    }
}
