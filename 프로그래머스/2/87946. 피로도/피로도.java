class Solution {
    static boolean[] visited;
    static int answer;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        answer = 0;
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        // 매 탐색마다 최대값 갱신
        answer = Math.max(answer, depth);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 아직 방문 안 했고, 최소 필요 피로도 충족하면
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons); // 소모 피로도만큼 줄이고 다음으로
                visited[i] = false; // 다시 원상복구 (백트래킹)
            }
        }
    }
}
