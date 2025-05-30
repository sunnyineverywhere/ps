package boj.p1629;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1) 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 2) solution 호출 및 결과 출력
        long result = solution(A, B, C);
        System.out.println(result);
    }

    /**
     * @param A 밑 (1 ≤ A ≤ 100,000)
     * @param B 지수 (0 ≤ B ≤ 10^9)
     * @param C 모듈러 (1 ≤ C ≤ 100,000)
     * @return (A^B) mod C
     */
    public static long solution(int A, long B, int C) {
        return modular(A, B, C);
    }

    public static long modular(int A, Long B, int C) {
        if (B == 0) return 1 % C;
        long half = modular(A, B/2, C);
        long res = (half * half) % C;
        if (B % 2 == 1) {
            res = (res * A) % C;
        }
        return res;
    }
}
