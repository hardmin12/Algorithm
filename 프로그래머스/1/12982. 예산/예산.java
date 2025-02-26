import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d); //신청 금액 오름차순 정렬
        
        for(int cost : d) {
            if (budget >= cost) {
                budget -= cost;
                answer++; //지원한 부서 개수 증가
            } else {
                break; //예산 초과 시 종료
            }
        }
       
        
        return answer;
    }
}