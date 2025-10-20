package classes.problems.linkedlist;

import classes.utilities.LinkedListUtils;
import classes.utilities.structures.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.buildLinkedList(20);
        System.out.println("List Generated -> " + LinkedListUtils.stringList(head));
        System.out.println("Is Palindrome -> " + " " + isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return false;

        ListNode slow = head; ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while(slow != null){
           ListNode tmp = slow.next;
           slow.next = prev;
           prev = slow;
           slow = tmp;
        }

        slow = head;
        while(slow != null || fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

}
