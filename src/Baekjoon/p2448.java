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

        table = new boolean[N][N * 2];
        int degree = (int) baseLog(N / 3, 2);

        scatch(0, N - 1, degree);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (N * 2) - 1; j++) {
                if (table[i][j]) {
                    bw.write('*');
                } else {
                    bw.write(' ');
                }
            }
            bw.write('\n');
        }

        bw.flush();
    }

    static double baseLog(double x, double base) {
        return Math.log10(x) / Math.log10(base);
    }

    static void scatch(int startI, int startJ, int degree) {
        if (degree == 0) {
            table[startI][startJ] = true;
            table[startI + 1][startJ - 1] = true;
            table[startI + 1][startJ + 1] = true;
            for (int j = startJ - 2; j <= startJ + 2; j++) {
                table[startI + 2][j] = true;
            }
        } else {
            scatch(startI, startJ, degree - 1);
            scatch(startI + getHeightFromDegree(degree - 1), startJ - getWidthFromDegree(degree - 1) / 2, degree - 1);
            scatch(startI + getHeightFromDegree(degree - 1), startJ + getWidthFromDegree(degree - 1) / 2, degree - 1);
        }

    }

    static int getHeightFromDegree(int degree) {
        return 3 * (int) Math.pow(2, degree);
    }

    static int getWidthFromDegree(int degree) {
        return 3 * (int) Math.pow(2, degree + 1);
    }

}
