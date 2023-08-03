//https://leetcode.com/problems/add-two-numbers/submissions/
public class addTwoNumber{
//     /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         //Base ListNode
//         ListNode base=new ListNode(0);

//         //Moving head pointer
//         ListNode head=base;
//         int carry=0;

//         //Addition
//         while(l1!=null || l2!=null){
//             //getting values
//             int val1=(l1!=null)?l1.val:0;
//             int val2=(l2!=null)?l2.val:0;
            
//             //Computing sum
//             int sum=val1+val2+carry;
//             //Assigning value to carry
//             carry=sum/10;
//             sum=sum%10;
//             ListNode newNode=new ListNode(sum);
//             head.next=newNode;
//             head=head.next;
//             if(l1!=null){
//                 l1=l1.next;
//             }
//             if(l2!=null){
//                 l2=l2.next;
//             }
//         }
//         if(carry>0){
//             ListNode newNode=new ListNode(carry);
//             head.next=newNode;
//         }
//         return base.next;
//     }
// }
}