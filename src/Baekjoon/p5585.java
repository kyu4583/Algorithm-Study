package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p5585 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        x = 1000 - x;
        int i = 0;

        for (; x >= 500; i++) {
            x -= 500;
        }
        for (; x >= 100; i++) {
            x -= 100;
        }
        for (; x >= 50; i++) {
            x -= 50;
        }
        for (; x >= 10; i++) {
            x -= 10;
        }
        for (; x >= 5; i++) {
            x -= 5;
        }
        for (; x >= 1; i++) {
            x -= 1;
        }

        bw.write(Integer.toString(i));
        bw.flush();
    }
}
