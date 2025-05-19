import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // Call the solution method and capture its result if needed
        int[] result = solution(N, K);

        // Print the results as required by BOJ
        System.out.println(result[0]);  // shortest time
        System.out.println(result[1]);  // number of ways
    }


    // X-1, X+1, 2*X
    // N: 수빈의 위치
    // K: 동생의 위치
    public static int[] solution(int N, int K) {

        int max = 100000;
        int[] time = new int[max + 1];
        int[] count = new int[max + 1];
        Arrays.fill(time, -1);
        Queue<Integer> q = new LinkedList<>();

        time[N] = 0;
        count[N] = 1;
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : new int[]{cur -1, cur +1, cur *2}) {
                if (next < 0 || next > max) {
                    continue;
                }

                if (time[next] == -1) {
                    time[next] = time[cur] + 1;
                    count[next] = count[cur];
                    q.offer(next);
                } else if (time[next] == time[cur] + 1) {
                    count[next] += count[cur];
                }
            }
        }

        return new int[]{time[K], count[K]};
    }
}
