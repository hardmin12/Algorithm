class Solution {
    public long solution(int price, int money, int count) {
        long total = 0; // 놀이기구 이용 총 비용을 저장하는 변수

        for (int i = 1; i <= count; i++) {
            total += (long) price * i; // price * i 값을 누적해서 더함
        }

        long answer = total - money; // 부족한 금액 계산

        return (answer > 0) ? answer : 0; // 부족한 금액이 없으면 0 반환
    }
}