import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        
        // 그래프 초기화
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        depth = new int[n + 1];
        
        for(int i =1; i<=n; i++) {
            graph[i] = new ArrayList<>();
            depth[i] = -1; //방문하지 않은 노드는 1로 초기화
        }
        
        //연결 정보 저장(무방향 그래프)
        for (int i =0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        //인접 정점 내림차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        
        //DFS 실행
        dfs(r , 0);
        
        //결과 출력
        for (int i = 1; i<=n; i++) {
            System.out.println(depth[i]);
        }
        
    }
    
    static void dfs(int node, int d) {
        visited[node] = true;
        depth[node] = d;
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, d + 1);
            }
        }
    }
}