package com.nogayhusrev.cydeo;

public class PrintMiddleNodeOfLinkedList {
    
    public static void main(String[] args) {
        
        MySinglyLinkedList list = new MySinglyLinkedList();
        
        for (int i = 1; i <= 200; i++) {
            list.add(i);
        }
        
        printMiddleNode(list);
        
        
    }
    
    public static void printMiddleNode(MySinglyLinkedList sll) {
        
        Node a = sll.getHead();
        Node b = sll.getHead();
        
        while (b != sll.getTail() && b.next != sll.getTail()) {
            a = a.next;
            b = b.next.next;
        }
        
        if (b == sll.getTail())
            System.out.println(a.getId());
        else
            System.out.println(a.getId() + "," + a.next.getId());
        
    }
    
    
}
