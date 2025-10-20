package classes.utilities;

import classes.utilities.structures.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListUtils {

    public static ListNode buildLinkedList(int nodeAm) {
        Random random = new Random();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(int i = 0; i <= nodeAm; i++){
            ListNode node = new ListNode(random.nextInt(1, 50));
            tail.next = node;
            tail = node;
        }

        return dummy.next;
    }

    public static List<Integer> stringList(ListNode head) {
        List<Integer> out = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null){
            out.add(ptr.val);
            ptr = ptr.next;
        }

        return out;
    }

}
