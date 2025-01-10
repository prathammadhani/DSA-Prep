// Problem Name: Implement Trie (Prefix Tree)
// Problem Link: https://leetcode.com/problems/implement-trie-prefix-tree/

class Node {

    public Node[] links = new Node[26];
    public boolean flag = false;

    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    public Node get(Character ch) {
        return links[ch - 'a'];
    }

    public void put(Character ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void setFlag() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
 }

class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i)) == false) {
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setFlag();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i)) == false) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0;i<prefix.length();i++) {
            if(node.containsKey(prefix.charAt(i)) == false) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */