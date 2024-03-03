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
        int lenS = S.length();
        int lenT = T.length();
        int[] passedB = new int[lenT];
        int totalB = 0;
        for (int i = 0; i < lenT; i++) {
            passedB[i] = totalB;
            if (T.charAt(i) == 'B') {
                totalB += 1;
            }
        }

        StringBuilder builder = new StringBuilder(S);
        String reversedS = builder.reverse().toString();

        boolean answerd = false;
        for (int i = 0; i < lenT - lenS + 1; i++) {
            int leftIndex = i;
            int rightIndex = i + lenS - 1;
            if (T.substring(leftIndex, rightIndex + 1).equals(S)) {
                int leftB = passedB[leftIndex];
                //int containB = passedB[rightIndex + 1] - passedB[leftIndex];
                int rightB = totalB - passedB[rightIndex];
                if (T.charAt(rightIndex) == 'B') {
                    rightB -= 1;
                }
                if (leftB == rightB) {
                    answerCorrect();
                    answerd = true;
                    break;
                }
            }
        }

        if (!answerd) {
            for (int i = 0; i < lenT - lenS + 1; i++) {
                int leftIndex = i;
                int rightIndex = i + lenS - 1;
                if (T.substring(leftIndex, rightIndex + 1).equals(reversedS)) {
                    int leftB = passedB[leftIndex];
                    //int containB = passedB[rightIndex + 1] - passedB[leftIndex];
                    int rightB = totalB - passedB[rightIndex];
                    if (T.charAt(rightIndex) == 'B') {
                        rightB -= 1;
                    }
                    if (leftB - rightB == 1) {
                        answerCorrect();
                        answerd = true;
                        break;
                    }
                }
            }
        }

        if (!answerd) {
            bw.write("0");
            bw.flush();
        }

    }

    public static void answerCorrect() throws IOException {
        bw.write("1");
        bw.flush();
    }
}
