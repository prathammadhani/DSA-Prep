// Problem Name: Implement II
// Problem Link: https://www.naukri.com/code360/problems/implement-trie_1387095

import java.util.* ;
import java.io.*;
class Node {
    public Node[] links = new Node[26];
    public int cntEndsWith = 0;
    public int cntPrefix = 0;

    public boolean containsKey(Character ch) {
        return links[ch - 'a'] != null;
    }
    public Node get(Character ch) {
        return links[ch - 'a'];
    }
    public void put(Character ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void incPrefixCount() {
        cntPrefix++;
    }

    public void decPrefixCount() {
        cntPrefix--;
    }

    public void incEndsWithCount() {
        cntEndsWith++;
    }

    public void decEndsWithCount() {
        cntEndsWith--;
    }

    public int getPrefixCount() {
        return cntPrefix;
    }

    public int getEndsWitCount() {
        return cntEndsWith;
    }
}
public class Trie {
    private Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.incPrefixCount();
        }
        node.incEndsWithCount();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getEndsWitCount();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getPrefixCount();
    }

    public void erase(String word) {
        Node node = root;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                return;
            }
            node = node.get(word.charAt(i));
            node.decPrefixCount();
        }
        node.decEndsWithCount();
    }

}
