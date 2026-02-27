//Problem Name: Add Two Number
//Problem Link: https://leetcode.com/problems/add-two-numbers/description/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* temp1 = l1;
        ListNode* temp2 = l2;
        ListNode* dummyNode = new ListNode(-1);
        ListNode* temp = ans;
        int sum = 0, carry = 0;
        while(temp1!=NULL || temp2!=NULL) {
            int digit1 = (temp1!=NULL) ? temp1->val:0;
            int digit2 = (temp2!=NULL) ? temp2->val:0;
            sum = digit1 + digit2 + carry;
            carry = sum/10;
            temp->next = new ListNode(sum%10);
            temp = temp->next; 
            if(temp1!=NULL) temp1 = temp1->next;
            if(temp2!=NULL) temp2 = temp2->next;
        }
        if(carry>0) {
            temp->next = new ListNode(carry);
        }
        return ans->next;
    }
};