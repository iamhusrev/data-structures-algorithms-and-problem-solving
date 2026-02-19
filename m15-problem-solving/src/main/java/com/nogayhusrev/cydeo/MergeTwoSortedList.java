package com.nogayhusrev.cydeo;

public class MergeTwoSortedList {

    public static void main(String[] args) {

        MySinglyLinkedList a = new MySinglyLinkedList();
        MySinglyLinkedList b = new MySinglyLinkedList();
        for (int i = 1; i <= 50; i+=2) {
            a.add(i);
        }
        for (int i = 0; i <= 15; i++) {
            b.add(i);
        }

        a = mergeTwoSorted(a, b);
        a.printNodes();


    }

    public static MySinglyLinkedList mergeTwoSorted(MySinglyLinkedList listA, MySinglyLinkedList listB) {
        Node currA = listA.head;
        Node currB = listB.head;

        Node tempHead = new Node();
        Node prev = tempHead;

        while (currA != null && currB != null) {
            if (currA.id <= currB.id) {
                prev.next = currA;
                currA = currA.next;
            } else {
                prev.next = currB;
                currB = currB.next;
            }
            prev = prev.next;
        }

        if (currA == null) prev.next = currB;
        else prev.next = currA;

        listA.head = tempHead.next;
        return listA;
    }

}
