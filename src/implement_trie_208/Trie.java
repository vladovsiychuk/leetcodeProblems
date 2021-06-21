package implement_trie_208;

import java.util.HashMap;

public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()){
            if (!current.edges.containsKey(c))
                current.edges.put(c,new TrieNode());
            current = current.edges.get(c);
        }
        current.endWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()){
            if (!current.edges.containsKey(c))
                return false;
            current = current.edges.get(c);
        }
        return current.endWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()){
            if (!current.edges.containsKey(c))
                return false;
            current = current.edges.get(c);
        }
        return false;
    }

    private class TrieNode {
        HashMap<Character,TrieNode> edges;
        boolean endWord;

        public TrieNode(){
            edges = new HashMap<>();
            endWord = false;
        }
    }
}










