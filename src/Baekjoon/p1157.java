package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p1157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        int[] count = new int[26];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < input.length(); i++) {
            char chr = input.charAt(i);
            if (chr >= 'a') {
                chr -= 'a';
            } else if (chr >= 'A') {
                chr -= 'A';
            }
            count[chr] += 1;
        }

        int indexOfMax = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > count[indexOfMax]) {
                indexOfMax = i;
            }
        }

        boolean isDuplicated = false;
        for (int i = 0; i < count.length; i++) {
            if (i != indexOfMax && count[i] == count[indexOfMax]) {
                isDuplicated = true;
            }
        }

        char answer = (char) indexOfMax;

        if (isDuplicated) {
            bw.write('?');
        } else {
            bw.write(answer + 'A');
        }
        bw.flush();
    }
}
