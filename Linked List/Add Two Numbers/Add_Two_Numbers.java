//Problem Name: Add Two Number
//Problem Link: https://leetcode.com/problems/add-two-numbers/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        int sum = 0, carry = 0;
        while(temp1!=null || temp2!=null) {
            int digit1 = (temp1!=null) ? temp1.val : 0;
            int digit2 = (temp2!=null) ? temp2.val : 0;
            sum = digit1 + digit2 + carry;
            temp.next = new ListNode(sum%10);
            carry = sum/10;
            if(temp1!=null) temp1 = temp1.next;
            if(temp2!=null) temp2 = temp2.next;
            temp = temp.next;
        }
        if(carry>0) {
            temp.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}