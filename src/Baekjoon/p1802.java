package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class p1802 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        List<String> papers = new ArrayList<>();
        for (int i=0; i<num; i++) {
            papers.add(br.readLine());
        }

        for (int i=0; i<num; i++) {
            String paper = papers.get(i);
            int answer = fold(paper).length();
            if (answer == 1) {
                bw.write("YES");
            }
            if (answer == 0) {
                bw.write("NO");
            }
            bw.newLine();
        }

        bw.flush();

    }

    private static String fold(String paper) {
        int len = paper.length();
        if (len % 2 != 1) {
            return "";
        }
        if (len == 1) {
            return paper;
        }
        for(int i=0; i<len/2; i++) {
            if(paper.charAt(i) + paper.charAt(len-1-i) - '0' - '0' != 1) {
                return "";
            }
        }
        return fold(paper.substring(0, len/2));
    }
}
