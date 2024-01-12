package Baekjoon;

import java.io.*;
import java.util.*;

public class p17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] space = new int[N][M];  //사용자 입력으로 이뤄진 테이블
        int[][][] table = new int[N][M][3]; //계산중인 테이블, 3차 크기(3)는 이전 행에서 이동한 방향의 경우의 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                table[0][i][j] = space[0][i];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //좌상단에서 내려오는 계산
                if (j == 0) {
                    table[i][j][0] = Integer.MAX_VALUE;
                } else {
                    table[i][j][0] = space[i][j] + Collections.min(
                            List.of(table[i - 1][j - 1][1],
                                    table[i - 1][j - 1][2])
                    );
                }
                //정방향에서 내려오는 계산
                table[i][j][1] = space[i][j] + Collections.min(
                        List.of(table[i - 1][j][0],
                                table[i - 1][j][2])
                );
                //우상단에서 내려오는 계산
                if (j == M - 1) {
                    table[i][j][2] = Integer.MAX_VALUE;
                } else {
                    table[i][j][2] = space[i][j] + Collections.min(
                            List.of(table[i - 1][j + 1][0],
                                    table[i - 1][j + 1][1])
                    );
                }

            }
        }

        int min = table[N - 1][0][0];
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                if (table[N - 1][j][k] <= min) {
                    min = table[N - 1][j][k];
                }
            }
        }

        bw.write(Integer.toString(min));
        bw.flush();
    }
}
