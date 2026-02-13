// Day 24 - Alien Dictionary
// LeetCode #269
// Concept: Topological Sort (Kahn's Algorithm)

import java.util.*;

class Solution {

    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());

            for (int j = 0; j < minLen; j++) {

                if (w1.charAt(j) != w2.charAt(j)) {

                    if (!graph.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        graph.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet())
            if (indegree.get(c) == 0)
                queue.offer(c);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {

            char curr = queue.poll();
            sb.append(curr);

            for (char nei : graph.get(curr)) {
                indegree.put(nei, indegree.get(nei) - 1);
                if (indegree.get(nei) == 0)
                    queue.offer(nei);
            }
        }

        return sb.length() == indegree.size() ? sb.toString() : "";
    }
            }
