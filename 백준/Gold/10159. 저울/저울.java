import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static int n;
    static ArrayList<Integer>[] heavyGraph;
    static ArrayList<Integer>[] lightGraph;
    static boolean[] visited;
    
    //DFS 함수
    static int dfs(int node, ArrayList<Integer>[] graph) {
        visited[node] = true;
        int count = 0;
        
        for(int next : graph[node]) {
            if (!visited[next]) {
                count++;
                count += dfs(next, graph);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //입력 받기
        n = sc.nextInt(); //물건 개수
        int m = sc.nextInt(); //비교 결과 개수
        
        //그래프 초기화
        heavyGraph = new ArrayList[n + 1];
        lightGraph = new ArrayList[n + 1];
        
        for (int i =1; i<=n; i++) {
            heavyGraph[i] = new ArrayList<>();
            lightGraph[i] = new ArrayList<>();
        }
        
        //입력으로 그래프 생성
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            // 정방향 그래프 (A>B)
            heavyGraph[a].add(b);
            // 역방향 그래프 (B<A)
            lightGraph[b].add(a);
        }
        //결과 저장 배열
        int[] result = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            //정방향 탐색(자신보다 가벼운 물건 개수)
            visited = new boolean[n + 1];
            int heavyCount = dfs(i, heavyGraph);
            
            //역방향 탐색(자신보다 무거운 물건 개수)
            visited = new boolean[n + 1];
            int lightCount = dfs(i, lightGraph);
            
            //알 수 없는 물건 개수 계산
            result[i] = n - (heavyCount + lightCount) - 1;
        }
        //결과 출력
        for(int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
        
        sc.close();
        
    }
}