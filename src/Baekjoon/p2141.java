package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static java.lang.Math.round;

public class p2141 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String[] chars = br.readLine().split(" ");
            int x = Integer.parseInt(chars[0]);
            int a = Integer.parseInt(chars[1]);
            sum += x * a;
            m += a;
        }

        bw.write(Integer.toString((int) round((double) sum / m)));
        bw.flush();
    }
}