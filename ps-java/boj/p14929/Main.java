package boj.p14929;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열 길이
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // solution 호출
        long result = solution(N, A);
        System.out.println(result);
    }

    public static long solution(int N, int[] A) {
        long total = 0;
        for (int num : A) {
            total += num;
        }

        long answer = 0;

        for (int i = 0; i < N; i++)  {
            total -= A[i];
            answer += (long) total * A[i];
        }

        return answer;
    }
}

