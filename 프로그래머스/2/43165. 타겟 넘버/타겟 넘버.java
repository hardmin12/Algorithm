class Solution {
        int answer = 0; //경우의 수 저장
        
        public int solution(int[] numbers, int target) {
            dfs(numbers, target, 0, 0); //DFS 탐색 시작
            return answer;
        }
        
        //DFS 함수
        public void dfs(int[] numbers, int target, int index, int sum) {
            if (index == numbers.length) {
                //목표 값과 합이 같으면 경우의 수 증가
                if (sum == target) {
                    answer++;
                }
                return;
            }
            //현재 숫자를 더하는 경우
            dfs(numbers, target, index + 1, sum + numbers[index]);
            //현재 숫자를 빼는 경우
            dfs(numbers, target, index + 1, sum - numbers[index] );
        }
        
    }
