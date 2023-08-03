//https://leetcode.com/problems/intersection-of-two-linked-lists/description/

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class IntersectionOfTwoLinkList {
   
// public class Solution {

    //Calculating Length of ListNode
//     public int length(ListNode node){
//         int count=0;
//         while(node!=null){
//             node=node.next;
//             count++;
//         }
//         return count;
//     }
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
//         //Assingning length
//         int lA=length(headA);
//         int lB=length(headB);

//         //Assining ListNode
//         ListNode currA=null;
//         ListNode currB=null;
        
//         //Calculating difference
//         int diff=0;
//         if(lA>lB){
//             diff=lA-lB;
//             currA=headA;
//             currB=headB;
//         }else{
//             diff=lB-lA;
//             currA=headB;
//             currB=headA;
//         }

//         //Making Equal length to start
//         while(diff!=0){
//             diff--;
//             currA=currA.next;
//          }

//          //Moving forward for finding intersection point
//          while(currA!=null && currB!=null ){
//              if(currA==currB){
//                  return currA;
//              }
//              currA=currA.next;
//              currB=currB.next;
//          }

//          return null;
//     }
// }
}
