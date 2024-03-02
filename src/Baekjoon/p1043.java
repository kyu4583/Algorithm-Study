package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class p1043 {
    static boolean[][] graph;
    static boolean[] truth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Nt = Integer.parseInt(st.nextToken());
        truth = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            truth[i] = false;
        }

        graph = new boolean[N + 1][N + 1];
        if (Nt > 0) {
            int knows = Integer.parseInt(st.nextToken());
            truth[knows] = true;
            int preKnows = knows;

            for (int i = 1; i < Nt; i++) {
                knows = Integer.parseInt(st.nextToken());
                graph[preKnows][knows] = true;
                graph[knows][preKnows] = true;
                preKnows = knows;
            }
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
                int people = Integer.parseInt(st.nextToken());
                peopleInCurrentParty[j] = people;
            }
            for (int j = 1; j < Np; j++) {
                graph[peopleInCurrentParty[j - 1]][peopleInCurrentParty[j]] = true;
                graph[peopleInCurrentParty[j]][peopleInCurrentParty[j - 1]] = true;
            }
        }

        for (int i = 0; i < truth.length; i++) {
            if (truth[i]) {
                traversal(i);
                break;
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

    public static void traversal(int index) {
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i]) {
                if (!truth[i]) {
                    truth[i] = true;
                    traversal(i);
                }
            }
        }
    }
}
