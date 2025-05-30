package boj.p1021;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 큐 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑을 수 개수

        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // solution 호출
        int result = solution(N, targets);
        System.out.println(result);
    }

    public static int solution(int N, int[] targets) {
        int answer = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }

        for (int target : targets) {
            int idx = 0;
            for (int x : dq) {
                if (x == target) break;
                idx++;
            }

            int left = idx;
            int right = dq.size() - idx;

            if (left <= right) {
                answer += left;
                while (left-- > 0) {
                    dq.offerLast(dq.pollFirst());
                }
            }
            else {
                answer += right;
                while (right-- > 0) {
                    dq.offerFirst(dq.pollLast());
                }
            }

            dq.pollFirst();
        }

        return answer;
    }
}
