package boj.p15654;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /* 1) 입력 처리 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 총 숫자 개수
        int M = Integer.parseInt(st.nextToken());   // 뽑을 숫자 개수

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        /* 2) solution 호출 */
        List<List<Integer>> result = solution(N, M, nums);

        /* 3) 결과 출력 (문제 출력 형식: 각 순열을 한 줄, 공백 구분) */
        StringBuilder sb = new StringBuilder();
        for (List<Integer> seq : result) {
            for (int i = 0; i < seq.size(); i++) {
                sb.append(seq.get(i));
                if (i < seq.size() - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }


    public static List<List<Integer>> solution(int N, int M, int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[N];

        dfs(N, M, nums, visited, path, answer);

        return answer;
    }

    public static void dfs(int N, int M, int[] nums,
                           boolean[] visited,
                           List<Integer> path,
                           List<List<Integer>> answer
                           ) {
        if (path.size() == M) {
            if (!answer.contains(path)) {
                answer.add(path);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            path.add(nums[i]);
            dfs(N, M, nums, visited, path, answer);
            path.remove(path.size() - 1);
            visited[i] = false;
        }

    }
}
