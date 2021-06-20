package implement_trie_208;

import java.util.HashMap;

public class Trie {
    HashMap<Character,Trie> edges;
    boolean isWordEnd;

    public Trie() {
        edges = new HashMap<>();
        isWordEnd=false;
    }

    public void insert(String word) {
        Trie current = this;
        for (char c : word.toCharArray()){
            if (!current.edges.containsKey(c))
                current.edges.put(c,new Trie());
            else
                current = current.edges.get(c);
        }
        current.isWordEnd = true;
    }

    public boolean search(String word) {
        Trie current = this;
        for (char c : word.toCharArray()){
            if (!current.edges.containsKey(c))
                return false;
            else
                current = current.edges.get(c);
        }
        return current.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (char c : prefix.toCharArray()){
            if (!current.edges.containsKey(c))
                return false;
            else
                current = current.edges.get(c);
        }
        return true;
    }
}










