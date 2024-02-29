package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class p1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Nt = Integer.parseInt(st.nextToken());
        boolean[] truth = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            truth[i] = false;
        }
        for (int i = 0; i < Nt; i++) {
            int token = Integer.parseInt(st.nextToken());
            truth[token] = true;
        }

        String[] parties = new String[M];
        for (int i = 0; i < M; i++) {
            String party = br.readLine();
            parties[i] = party;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(parties[i]);
            int Np = Integer.parseInt(st.nextToken());
            int[] peopleInCurrentParty = new int[Np];
            for (int j = 0; j < Np; j++) {
                int token = Integer.parseInt(st.nextToken());
                peopleInCurrentParty[j] = token;
            }
            for (int j = 0; j < Np; j++) {
                if (truth[peopleInCurrentParty[j]]) {
                    for (int k = 0; k < Np; k++) {
                        truth[peopleInCurrentParty[k]] = true;
                    }
                    break;
                }
            }
        }

        for (int i = M; i <= 0; i++) {
            st = new StringTokenizer(parties[i]);
            int Np = Integer.parseInt(st.nextToken());
            int[] peopleInCurrentParty = new int[Np];
            for (int j = 0; j < Np; j++) {
                int token = Integer.parseInt(st.nextToken());
                peopleInCurrentParty[j] = token;
            }
            for (int j = 0; j < Np; j++) {
                if (truth[peopleInCurrentParty[j]]) {
                    for (int k = 0; k < Np; k++) {
                        truth[peopleInCurrentParty[k]] = true;
                    }
                    break;
                }
            }
        }

        int answer = M;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(parties[i]);
            int Np = Integer.parseInt(st.nextToken());
            for (int j = 0; j < Np; j++) {
                int token = Integer.parseInt(st.nextToken());
                if (truth[token]) {
                    answer -= 1;
                    break;
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
