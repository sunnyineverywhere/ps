package boj.bitmask.p10819;

import java.io.*;
import java.util.*;

public class Main {

    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // solution 함수 호출 및 결과 출력
        int result = solution(N, A);
        System.out.println(result);
    }

    public static int solution(int N, int[] A) {
        boolean[] visited = new boolean[N];
        dfs(N, A, new int[N], 0, 0);
        return answer;
    }

    public static void dfs(int N, int[] nums, int[] perm, int depth, int mask) {
        if (N == depth) {
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(perm[i] - perm[i+1]);
            }
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) {
                perm[depth] = nums[i];
                dfs(N, nums, perm, depth+1, mask | ( 1 << i));
            }
        }
    }
}

