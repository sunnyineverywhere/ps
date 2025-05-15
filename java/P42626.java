/**
프로그래머스 고득점 Kit / 더 맵게

우선순위큐를 사용해서 스코빌지수를 항상 오름차순으로 유지
제일 스코빌지수가 낮은 pq의 peek를 계속해서 계산한다
pq로 푸는 그리디


*/

import java.util.*;


/*
섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
*/
class Solution {
    /**
    scoville 가진 음식의 모든 스코빌 지수를 담은 배열
    k 원하는 스코빌 지수
    */
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(scoville.length);
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int mixCnt = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            
            int leastSpicy = pq.poll();
            int secondSpicy = pq.poll();
            int mixedSpicy = leastSpicy + 2 * secondSpicy;
            pq.offer(mixedSpicy);
            mixCnt++;
        } 
        
        
        return mixCnt;
    }
}
