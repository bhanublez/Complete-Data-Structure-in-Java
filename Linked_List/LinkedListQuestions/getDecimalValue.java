//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/1013880656/
public class getDecimalValue {
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
// class Solution {
//     public int getDecimalValue(ListNode head) {
//         int size=-1;
//         int sum=0;
//         ListNode temp=head;
//         while(temp!=null){
//             temp=temp.next;
//             size++;
//         }
//         while(head!=null){
//             sum+=head.val*Math.pow(2,size--);
//             head=head.next;
//         }
//         return sum;
//     }
// }
}
