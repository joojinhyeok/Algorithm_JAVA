package main.java;

import java.util.*;

public class Bfs {
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    // 중복 방문 방지용으로 이미 방문한 노드를 다시 큐에 넣지 않기 위해 사용
    static Set<Integer> visited = new HashSet<>();

    // BFS: 너비우선탐색은 "큐"를 사용(선입선출)

    public static void bfs(int startVertex) {
        // 큐 생성 및 시작 정점 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited.add(startVertex);

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 현재 노드 꺼냄
            int curVertex = queue.remove();
            System.out.println("방문: " + curVertex); // 방문 출력

            // 인접 노드 순회
            for (int nextVertex : graph.get(curVertex)) {
                if (!visited.contains(nextVertex)) {
                    queue.add(nextVertex);
                    visited.add(nextVertex);
                }
            }
        }
    }

    private static void makeGraph() {
        // 정적 필드 graph에 직접 저장해야 함
        graph.put(0, List.of(1, 3, 6)); // 노드 0은 1,3,6과 연결되어 있다는 뜻
        graph.put(1, List.of(0, 3));
        graph.put(2, List.of(3));
        graph.put(3, List.of(0, 1, 2, 7));
        graph.put(4, List.of(5));
        graph.put(5, List.of(4, 6, 7));
        graph.put(6, List.of(0, 5));
        graph.put(7, List.of(3, 5));
    }

    public static void main(String[] args) {
        makeGraph();
        bfs(0);
    }
}
