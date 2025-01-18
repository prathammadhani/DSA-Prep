// Problem Name: Implement II
// Problem Link: https://www.naukri.com/code360/problems/implement-trie_1387095

#include <bits/stdc++.h> 

class Node {
public:
    Node* links[26];
    int cntEndsWith = 0;
    int cntPrefix = 0;

    bool containsKey(char ch) {
        return links[ch-'a'] != NULL;
    }

    Node* get(char ch) {
        return links[ch-'a']; 
    }

    void put(char ch, Node* node) {
        links[ch-'a'] = node;
    }

    void incPrefixCount() {
        cntPrefix++;
    }

    void decPrefixCount() {
        cntPrefix--;
    }

    void incEndsWith() {
        cntEndsWith++;
    }

    void decEndsWith() {
        cntEndsWith--;
    }

    int getPrefixCount() {
        return cntPrefix;
    }

    int getEndsWithCount() {
        return cntEndsWith;
    }
};

class Trie{
    private:

    Node* root;

    public:

    Trie(){
        root = new Node();
    }

    void insert(string &word){
        Node* node = root;
        for(int i = 0;i<word.size();i++) {
            if(!node->containsKey(word[i])) {
                node->put(word[i], new Node());
            }
            node = node->get(word[i]);
            node->incPrefixCount();
        }
        node->incEndsWith();
    }

    int countWordsEqualTo(string &word){
        Node* node = root;
        for(int i = 0;i<word.size();i++) {
            if(!node->containsKey(word[i])){
                return 0;
            }
            node = node->get(word[i]);
        }
        return node->getEndsWithCount();
    }

    int countWordsStartingWith(string &word){
        Node* node = root;
        for(int i = 0;i<word.size();i++) {
            if(node->containsKey(word[i])){
                node = node->get(word[i]);
            } else {
                return 0;
            }
        }
        return node->getPrefixCount();
    }

    void erase(string &word){
        Node* node = root;
        for(int i = 0;i<word.size();i++) {
            if(node->containsKey(word[i])) {
                node = node->get(word[i]);
                node->decPrefixCount();
            } else {
                return;
            }
        }
        node->decEndsWith();
    }
};
