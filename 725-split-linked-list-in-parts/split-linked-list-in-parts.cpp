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
    vector<ListNode*> splitListToParts(ListNode* head, int k){
        ListNode* temp = head;

        vector<ListNode*> nodes;

        int len = 0;
        while(temp != NULL){
            len++;
            temp = temp->next;
        }

        temp = head;
        ListNode* prev = NULL;

        while(temp != NULL){
            int toDo = ceil(len/float(k));
            len -= toDo;
            --k;
            nodes.push_back(temp);

            while(temp != NULL && toDo != 0){
                prev = temp;
                temp = temp->next;
                toDo--;
            }

            prev->next = NULL;
        }

        while(k != 0){
            nodes.push_back({});
            --k;
        }

        return nodes;
    }

};