package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p2448 {
    static boolean[][] table;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        table = new boolean[N][(N * 2) - 1];
        int degree = (int) baseLog(N / 3, 2);

        scatch(0, N - 1, degree);


    }

    static double baseLog(double x, double base) {
        return Math.log10(x) / Math.log10(base);
    }




}
