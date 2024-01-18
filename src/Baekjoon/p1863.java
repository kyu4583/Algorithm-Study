package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1863 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int answer = 0;
        int nowHeight;
        for (int i = 0; i <= N; i++) {
            if (i == N) {
                nowHeight = 0;
            } else {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                nowHeight = Integer.parseInt(st.nextToken());
            }
            while (nowHeight < stack.peek()) {
                stack.pop();
                answer += 1;
            }
            if (nowHeight == stack.peek()) {
                continue;
            }
            stack.push(nowHeight);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
