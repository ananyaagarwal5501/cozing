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
    ListNode* doubleIt(ListNode* head) {
        ListNode* newNode = new ListNode(1);
        newNode->next = head;
        
        bool extra = false;
        if(head->val >= 5) extra = true;

        while(head != NULL){
            int val = (2*head->val)%10;
            int carry = 0;

            if(head->next && head->next->val >= 5) carry = 1;
            head->val = val + carry;
            head = head->next;
        }
        
        return  !extra ? newNode->next : newNode;
    }
};