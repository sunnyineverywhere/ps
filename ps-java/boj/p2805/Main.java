package boj.p2805;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 나무의 수
        long M = Long.parseLong(st.nextToken());    // 필요한 나무 길이

        long[] trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }

        // solution 호출 및 결과 출력
        long result = solution(N, M, trees);
        System.out.println(result);
    }

    /**
     * @param N     나무 개수
     * @param M     상근이가 가져가려는 나무 길이
     * @param trees 각 나무의 높이 배열
     * @return      절단기의 높이 H의 최댓값
     */
    public static long solution(int N, long M, long[] trees) {
        long answer = -1L;

        long left = 0L;
        long right = Arrays.stream(trees).max().getAsLong();

        while (left < right) {
            long mid = (left + right) / 2;

            long cnt = 0L;

            for (long tree : trees) {
                if (tree > mid) {
                    cnt += tree - mid;
                }
            }

            if (cnt < M) {
                right = mid;
            }
            else {
                answer = mid;
                left = mid + 1;
            }

        }

        return answer;
    }
}
