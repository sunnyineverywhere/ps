package boj.p5430;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // --- 입력 파싱 ---
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String commands = br.readLine().trim();         // ex: "RDD"
            int n = Integer.parseInt(br.readLine().trim()); // 배열 길이
            String line = br.readLine().trim();             // ex: "[1,2,3,4]"

            // 문자열 "[...]"에서 숫자만 분리
            int[] arr = parseArray(line, n);

            // --- solution 호출 ---
            String result = solution(commands, arr);

            // --- 결과 누적 ---
            output.append(result).append('\n');
        }

        // --- 전체 출력 ---
        System.out.print(output);
    }

    /**
     * 문자열 "[x1,x2,...,xn]" 과 길이 n을 받아 int[] 로 파싱합니다.
     */
    private static int[] parseArray(String s, int n) {
        int[] a = new int[n];
        if (n == 0) return a;
        String[] parts = s.substring(1, s.length() - 1).split(",");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }
        return a;
    }

    /**
     * @param commands 'R'과 'D'로 이루어진 명령 문자열
     * @param arr      초기 배열 (길이 n)
     * @return         최종 배열을 "[...]" 형식으로,
     *                 혹은 error 시 "error" 반환
     */
    public static String solution(String commands, int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        boolean flag = false; // false -> first, true -> back

        for (int i = 0; i < commands.length(); i++) {
            if (commands.charAt(i) == 'R') {
                flag = !flag;
            }
            else {
                if (dq.isEmpty()) {
                    return "error";
                }

                if (flag) {
                    dq.pollLast();

                }
                else {
                    dq.pollFirst();
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append("[");
        while (!dq.isEmpty()) {
            if (flag) {
                answer.append(dq.pollLast());
            }
            else {
                answer.append(dq.pollFirst());
            }

            if (!dq.isEmpty()) {
                answer.append(",");
            }
        }
        answer.append("]");

        return answer.toString();
    }
}

