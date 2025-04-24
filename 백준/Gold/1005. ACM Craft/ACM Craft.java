import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스 받기
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 빌딩 개수, 건설 규칙 개수 받기
            StringTokenizer stkn = new StringTokenizer(br.readLine());
            int buildingNum = Integer.parseInt(stkn.nextToken());
            int ruleNum = Integer.parseInt(stkn.nextToken());
            // 빌딩 건설 시간 어레이. 어레이에 저장
            int[] timeArray = new int[buildingNum + 1];
            stkn = new StringTokenizer(br.readLine());
            for (int j = 1; j < buildingNum + 1; j++) {
                timeArray[j] = Integer.parseInt(stkn.nextToken());
            }

            // 건설 테크를 저장하기 위한 BFS 생성
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < buildingNum + 1; j++) {
                graph.add(new ArrayList<>());
            }

            // 위상 정렬을 위한 진입 차수
            int[] indegree = new int[buildingNum + 1];

            // 건설 규칙 받기
            for (int j = 0; j < ruleNum; j++) {
                stkn = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stkn.nextToken());
                int y = Integer.parseInt(stkn.nextToken());
                // x가 지어진 후 y 건설 가능 graph.get(x)에 y 추가, y의 진입 차수++
                graph.get(x).add(y);
                indegree[y]++;
            }
            // 건물 별 건설 시간 계산용 어레이
            int[] totalTime = new int[buildingNum + 1];
            //위상 정렬 시작
            Queue<Integer> queue = new LinkedList<>();

            // 진입 차수가 0인 건물 -> 바로 지을 수 있는 건물부터 큐에 추가
            for (int j = 1; j < buildingNum + 1; j++) {
                if (indegree[j] == 0) {
                    queue.offer(j);
                    // 바로 지을 수 있는 건물의 건설 시간으로 초기화
                    totalTime[j] = timeArray[j];
                }
            }

            // 위상 정렬 BFS
            // 큐가 빌때까지 반복
            while (!queue.isEmpty()) {
                int current = queue.poll();
                // 큐에서 하나를 꺼내 다음 건물 어레이에 대해서 반복
                for (int next : graph.get(current)) {
                    // current가 건설됐으니 current의 다음 건물들의 진입차수--
                    indegree[next]--;
                    // 다음 건물의 건설 소요 시간을 이전에 계산한 시간과 이번 건물까지의 시간 + 다음 건물 건설 시간과 비교해 더 큰 시간 선택
                    totalTime[next] = Math.max(totalTime[next], totalTime[current] + timeArray[next]);
                    // 진입차수가 0이라면 다음으로
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            // 소요 시간을 구해야하는 빌딩 받기
            int W = Integer.parseInt(br.readLine());
            System.out.println(totalTime[W]);
        }

        br.close();
    }
}
