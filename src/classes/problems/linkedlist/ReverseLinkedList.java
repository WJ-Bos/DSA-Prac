package classes.problems.linkedlist;

import classes.utilities.LinkedListUtils;
import classes.utilities.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = LinkedListUtils.buildLinkedList(30);
        System.out.println("List created  -> " +LinkedListUtils.stringList(list));
        System.out.println("List reversed -> " + LinkedListUtils.stringList(reverseLinkedList(list)));
    }

    public static ListNode reverseLinkedList(ListNode head){
        if(head == null) return head;

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
}
