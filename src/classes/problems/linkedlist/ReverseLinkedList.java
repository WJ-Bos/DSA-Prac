package classes.problems.linkedlist;

import classes.utilities.LinkedListUtils;
import classes.utilities.structures.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = LinkedListUtils.buildLinkedList(30);
        System.out.println("List created  -> " +LinkedListUtils.stringList(list));
        System.out.println("List reversed recurse-> " + LinkedListUtils.stringList(reverse(list)));
    }

    public static ListNode reverseLinkedList(ListNode head){
        if(head == null) return null;

        ListNode ptr = head;
        ListNode prev = null;
        while(ptr != null){
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = temp;
        }

        return prev;
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

       ListNode newHead = reverse(head.next);
       head.next.next = head;
       head.next = null;

       return newHead;
    }
}
