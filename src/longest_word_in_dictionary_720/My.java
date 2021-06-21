package longest_word_in_dictionary_720;

import implement_trie_208.Trie;

import java.util.HashMap;

public class My {
    public String result(String[] words){
        Trie trie = new Trie();
        String longest = "";
        for (String word : words)
            trie.insert(word);

        for (String word : words){
            if (trie.search(word)){
                if (word.length()>longest.length())
                    longest = word;
                else if (word.length()== longest.length()){
                    int comp = longest.compareTo(word);
                    if (comp < 0)
                        longest = word;
                }
            }
        }
        return longest;
    }

    class Trie {
        TrieNode root;
        public Trie (){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode current = root;
            for (char c : word.toCharArray()){
                if (!current.edges.containsKey(c))
                    current.edges.put(c, new TrieNode());
                current = current.edges.get(c);
            }
            current.endWord = true;
        }

        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()){
                if (!current.edges.containsKey(c))
                    return false;
                if (!current.edges.get(c).endWord)
                    return false;
                current = current.edges.get(c);
            }
            return current.endWord;
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
}

