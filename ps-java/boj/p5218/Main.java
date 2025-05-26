package boj.p5218;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<String> inputs = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            inputs.add(br.readLine());
        }

        // solution 호출
        List<String> result = solution(inputs);

    }

    public static List<String> solution(List<String> inputs) {
        for (String input: inputs) {
            String[] words = input.split(" ");
            String a = words[0]; String b = words[1];
            System.out.print("Distances: ");
            for (int i = 0; i < a.length(); i++) {
                int distance = 0;

                if (a.charAt(i) <= b.charAt(i)) {
                    distance = b.charAt(i) - a.charAt(i);
                }
                else {
                    distance = b.charAt(i) + 26 - a.charAt(i);
                }

                System.out.print(distance);
                System.out.print(" ");
            }
            System.out.println();
        }
        return new ArrayList<>();
    }
}