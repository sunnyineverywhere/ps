package boj.p16953;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // solution 호출 및 결과 출력
        int result = solution(A, B);
        System.out.println(result);
    }

    /*
    42 21 20 10 5
     */
    public static int solution(int A, int B) {
        int answer = -1;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{B, 1});

        while(!dq.isEmpty()) {
            int[] current = dq.poll();
            int number = current[0]; int count = current[1];
            // System.out.print(number); System.out.print(" "); System.out.println(count);

            if (number == A) {
                if (answer == -1) {
                    answer = count;
                }
                else if (count < answer) {
                    answer = count;
                }
                continue;
            }

            if (number % 2 == 0 && number != 0) {
                dq.offer(new int[]{number/ 2, count + 1});
            }
            else if (number % 10 == 1) {
                dq.offer(new int[]{(number-1) / 10, count + 1});
            }

        }

        return answer;
    }
}
