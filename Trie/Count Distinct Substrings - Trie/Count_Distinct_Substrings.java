// Problem Name: Count Distinct Substings
// Problem Link: https://www.naukri.com/code360/problems/count-distinct-substrings_985292


import java.util.ArrayList;

class Node {
    public Node[] links = new Node[26];
    public boolean endChar;

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void setFlag() {
        endChar = true;
    }

    public boolean isEnd() {
        return endChar;
    }
}

class Trie {

    private Node root;

    Trie() {
        root = new Node();
    }

    public boolean insert(String word) {
        Node node = root;
        boolean flag = false;
        for(int i = 0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                flag = true;
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setFlag();
        return flag;
    }
}

public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		Trie trie = new Trie();
		int ans = 1;
		for(int i = 0;i<s.length();i++) {
			for(int j = i+1;j<=s.length();j++) {
				String curr = s.substring(i,j);
				boolean result = trie.insert(curr);
				if(result) {
					ans++;
				}
			}
		}
		return ans;
	}
}

