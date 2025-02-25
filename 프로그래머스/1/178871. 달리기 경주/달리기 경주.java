import java.util.*;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        //선수의 현재 등수를 저장하는 hashmap
        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        //추월 처리
        for (String call : callings) {
            int curIdx = rank.get(call); //현재 등수
            if (curIdx > 0) { //1등이 아닌 경우만 추월 가능
                int prevIdx = curIdx - 1; //앞 선수 등수
                String prevPlayer = players[prevIdx];
                
                //Swap(자리 변경)
                players[prevIdx] = call;
                players[curIdx] = prevPlayer;
                
                //HashMap 갱신
                rank.put(call, prevIdx);
                rank.put(prevPlayer, curIdx);
                
                
            }
        }
        // 결과를 새로운 배열 answer에 저장하여 반환
        String[] answer = Arrays.copyOf(players, players.length);
        return answer;
    }
}