package com.piotrkafel.leetcode;

public class IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode firstNode = head;

        int length = 1;
        while(head.next != null) {
            head = head.next;
            length++;
        }

        ListNode midNode;
        head = firstNode;
        for(int i=0;i<length/2;i++) {
            head = head.next;
        }
        midNode=head;

        ListNode nextNode = midNode.next;
        midNode.next = null;
        ListNode tempNode;
        while(nextNode != null) {
            tempNode = nextNode.next;
            nextNode.next = midNode;
            midNode = nextNode;
            nextNode = tempNode;
        }

        for(int i=0;i<length/2;i++) {
            if(firstNode.val != midNode.val) return false;

            firstNode = firstNode.next;
            midNode = midNode.next;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1,
                new ListNode(0,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(0,
                                                new ListNode(1))))))));
    }
}
