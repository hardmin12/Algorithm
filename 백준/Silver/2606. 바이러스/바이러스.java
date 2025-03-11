import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 컴퓨터 수
        int m = sc.nextInt(); // 연결 쌍 수
        
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        //그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        //연결 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            graph[a].add(b);
            graph[b].add(a); //무방향 그래프라서 양쪽에 다 추가
        }
        
        //DFS 실행 (1번 노드부터 탐색 시작)
        dfs(1);
        
        //결과 출력(1번 노드는 제외해야하므로 -1)
        System.out.println(count - 1);
           
    }
    
    static void dfs(int node) {
        visited[node] = true;
        count ++;
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}