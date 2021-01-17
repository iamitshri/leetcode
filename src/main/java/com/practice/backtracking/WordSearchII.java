package com.practice.backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode {

    TrieNode[] child = new TrieNode[26];
    boolean isWord = false;

    TrieNode() {

    }
}

class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {

        HashSet<String> result = new HashSet<>();
        TrieNode root = new TrieNode();
        addWordsToTrie(root, words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (root.child[board[i][j] - 'a'] != null) {
                    dfs(board, root, i, j, "", result);
                }

            }
        }
        return new ArrayList<>(result);
    }


    void addWordsToTrie(TrieNode root, String[] words) {
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TrieNode();
                }
                node = node.child[c - 'a'];
            }
            node.isWord = true;
        }
    }

    void dfs(char[][] board, TrieNode root, int x, int y, String str, Set<String> result) {

        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || board[x][y] == '*') {
            return;
        }
        char c = board[x][y];
        if (root.child[c - 'a'] == null) {
            return;
        }
        root = root.child[c - 'a'];
        if (root.isWord) {
            result.add(str + board[x][y]);
            root.isWord = false;
        }
        board[x][y] = '*';
        dfs(board, root, x - 1, y, str + c, result);
        dfs(board, root, x + 1, y, str + c, result);
        dfs(board, root, x, y - 1, str + c, result);
        dfs(board, root, x, y + 1, str + c, result);
        board[x][y] = c;
    }
}