// Problem Name: Count Distinct Substrings
// Problem Link: https://www.naukri.com/code360/problems/count-distinct-substrings_985292

class Node {
public:
    Node* links[26];
    bool endChar;

    bool containsKey(char ch) {
        return links[ch - 'a'] != NULL;
    }

    Node* get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node* node) {
        links[ch - 'a'] = node;
    }

    void setFlag() {
        endChar = true;
    }

    bool isEnd() {
        return endChar;
    }
};

class Trie {
private:
    Node* root;
public: 
    Trie() {
        root = new Node();
    }

    bool insert(string word) {
        Node* node = root;
        bool flag = false;
        for(int i = 0;i<word.size();i++) {
            if(!node->containsKey(word[i])) {
                flag = true;
                node->put(word[i], new Node());
            }
            node = node->get(word[i]);
        }
        node->setFlag();
        return flag;
    }
};

int countDistinctSubstrings(string &s)
{
    Trie trie;
    int ans = 1;
    for(int i = 0;i<s.length();i++) {
        for(int j = i+1;j<=s.length();j++) {
            string curr = s.substr(i,j-i);
            bool result = trie.insert(curr);
            if(result) {
                ans++;
            }
        }
    }
    return ans;
}