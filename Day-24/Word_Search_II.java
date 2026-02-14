// Day 24 - Word Search II
// LeetCode #212
// Concept: Trie + Backtracking

import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, result);

        return result;
    }

    private void dfs(char[][] board, int i, int j,
                     TrieNode node, List<String> result) {

        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null)
            return;

        node = node.children[c - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int r = i + d[0], col = j + d[1];

            if (r >= 0 && col >= 0 &&
                r < board.length && col < board[0].length)
                dfs(board, r, col, node, result);
        }

        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {

        TrieNode root = new TrieNode();

        for (String word : words) {

            TrieNode node = root;

            for (char c : word.toCharArray()) {

                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();

                node = node.children[c - 'a'];
            }

            node.word = word;
        }

        return root;
    }
}
