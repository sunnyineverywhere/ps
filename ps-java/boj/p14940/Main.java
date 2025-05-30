package boj.p14940;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 행
        int M = Integer.parseInt(st.nextToken());   // 열

        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        /* Programmers-style solution 호출 */
        int[][] dist = solution(N, M, map);

        /* 결과 출력 */
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {          // 애초에 벽(0)인 곳
                    sb.append(0).append(' ');
                } else {
                    sb.append(dist[r][c]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    /**
     * @param N   행 크기
     * @param M   열 크기
     * @param map 0: 통행 불가, 1: 통행 가능, 2: 목표 지점
     * @return    각 칸까지의 최단거리 행렬
     *
     * (요구 사항)
     *   - 이동 불가능(0) 칸은 그대로 0
     *   - 도달 불가(1)이면 -1
     *   - 목표 지점(2)은 0
     */
    public static int[][] solution(int N, int M, int[][] map) {
        int[] target = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    target = new int[]{i, j};
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();

        dq.offer(target);

        int[][] dist = new int[N][M];
        for(int[] d : dist) {
            Arrays.fill(d, -1);
        }
        dist[target[0]][target[1]] = 0;

        while (!dq.isEmpty()) {
            int[] cxcy = dq.poll();

            for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int nx = cxcy[0] + dir[0];
                int ny = cxcy[1] + dir[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cxcy[0]][cxcy[1]] + 1;
                    dq.offer(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }
}

