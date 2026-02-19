package com.nogayhusrev.cydeo;

public class ReverseTheNodes {
    public static void main(String[] args) {
        
        MySinglyLinkedList a = new MySinglyLinkedList();
        for (int i = 1; i <= 50; i++) {
            a.add(i);
        }
        
        
        reverse(a);
        a.printNodes();
        
    }
    
    public static void reverse(MySinglyLinkedList list) {
        Node prev = list.head;
        Node curr = list.head.next;
        
        
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        list.tail = list.head;
        list.tail.next = null;
        list.head = prev;
        
        
    }
    
    
}
