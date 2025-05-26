package boj.p1158;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int K = Integer.parseInt(st.nextToken()); // 제거할 순번

        // solution 함수 호출
        List<Integer> answer = solution(N, K);
        System.out.print("<");
        for (int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i));
            if (i != answer.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }

    public static List<Integer> solution(int N, int K) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> josephus = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            josephus.add(i);
        }

        int idx = 0;
        while (answer.size() < N) {
            idx = (idx + K - 1) % josephus.size();
            answer.add(josephus.remove(idx));
        }

        return answer;
    }
}