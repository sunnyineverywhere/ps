package boj.bitmask.p1182;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // solution 함수 호출
        int result = solution(N, S, nums);
        System.out.println(result);
    }

    public static int solution(int N, int S, int[] nums) {
        int answer = 0;

        for (int bit = 1; bit < (1 << N); bit++) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if ((bit & (1 << i)) != 0) {
                    sum += nums[i];
                }
            }

            if (sum == S) {
                answer++;
            }
        }

        return answer;
    }


}

