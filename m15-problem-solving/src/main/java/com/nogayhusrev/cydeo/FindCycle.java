package com.nogayhusrev.cydeo;

import java.util.HashSet;

public class FindCycle {
    
    public static void main(String[] args) {
        
        MySinglyLinkedList a = new MySinglyLinkedList();
        
        
        for (int i = 1; i <= 50000; i++) {
            a.add(i);
            
        }
        
        
        long startTime2;
        long endTime2;
        System.out.println("---------------------isCycle2---------------------------");
        startTime2 = System.currentTimeMillis();
        System.out.println(isCycleWithHashset(a.getHead()));
        endTime2 = System.currentTimeMillis();
        System.out.println("isCycle2 " + (endTime2 - startTime2) + " milliseconds");
        
        long startTime;
        long endTime;
        System.out.println("---------------------hasCycle---------------------------");
        startTime = System.currentTimeMillis();
        System.out.println(hasCycle(a.getHead()));
        endTime = System.currentTimeMillis();
        System.out.println("hasCycle " + (endTime - startTime) + " milliseconds");
        
        
    }
    
    public static boolean isCycleWithHashset(Node head) {
        
        HashSet<Node> list = new HashSet<>();
        
        Node current = head;
        
        while (current != null) {
            current = current.next;
            if (!list.add(current))
                return true;
        }
        return false;
    }
    
    
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}
