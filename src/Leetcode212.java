package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode212 {
    private char[][] board;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.result = new ArrayList<>();

        Trie2 trie = new Trie2();
        for (String word : words) {
            trie.insert(word);
        }

        TrieNode root = trie.getRoot();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtrack(row, col, root);
                }
            }
        }

        return result;
    }

    private void backtrack(int row, int col, TrieNode parent) {
        char letter = board[row][col];
        TrieNode currNode = parent.children.get(letter);

        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null;
        }

        board[row][col] = '#';

        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int newRow = row + rowOffsets[d];
            int newCol = col + colOffsets[d];

            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }

            if (currNode.children.containsKey(board[newRow][newCol])) {
                backtrack(newRow, newCol, currNode);
            }
        }

        board[row][col] = letter;


        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
}

class Trie2 {
    private TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.word = word;
    }

    public TrieNode getRoot() {
        return root;
    }
}

