package com.nogayhusrev.cydeo;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MySinglyLinkedList {
    
    
    public Node head;
    public Node tail;
    public int size = 0;
    
    public void add(int data) {
        Node node = new Node(data);
        
        if (isEmpty()) {
            head = node;
            tail = node;
            size += 1;
        } else {
            tail.next = node;
            tail = tail.next;
            size += 1;
        }
        
        
    }
    
    public void addFirst(int data) {
        Node node = new Node(data);
        
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        
    }
    
    public int indexOf(int id) {
        if (isEmpty())
            return -1;
        
        int pos = 0;
        Node current = head;
        
        while (current != null) {
            if (id == current.id)
                return pos;
            current = current.next;
            pos++;
        }
        
        return -1;
        
    }
    
    public int getKthItemFromLast(int k) {
        Node ptr1 = head;
        Node ptr2 = head;
        
        for (int i = 0; i < k - 1; i++) {
            ptr2 = ptr2.next;
        }
        
        while (ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1.id;
        
    }
    
    public Node findKthFromEnd(Node head, int k) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        
        Node current = head;
        int index = 0;
        
        while (current != null) {
            nodeMap.put(index, current);
            current = current.next;
            index++;
        }
        
        int targetIndex = index - k;
        
        if (targetIndex < 0) return null;
        
        return nodeMap.get(targetIndex);
    }
    
    public void removeKthItemFromLast(int k) {
        
        Node ptr1 = head;
        Node ptr2 = head;
        for (int i = 0; i < k - 1; i++) {
            ptr2 = ptr2.next;
        }
        
        while (ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        delete(ptr1);
        
    }
    
    public void removeKthFromLast2(int k) {
        Node ptr1 = head;
        Node ptr2 = head;
        for (int i = 0; i < k - 1; i++) {
            
            ptr2 = ptr2.next;
            
            if (ptr2 == null) System.out.println("Less than k elements");
            
            else if (ptr2.next == null) {
                head = ptr1.next;
                ptr1.next = null;
                return;
            }
        }
        while (ptr2.next.next != null) {
            
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            
        }
        
        ptr1.next = ptr1.next.next;
        ptr1 = ptr1.next;
        ptr1 = null;
        
        
    }
    
    public void deleteById(int id) {
        
        Node prev = head;
        Node current = head;
        while (current != null) {
            if (current.id == id) {// there is a match
                
                if (current == head) {
                    head = current.next;
                    current.next = null;
                } else if (current == tail) {
                    tail = prev;
                    prev.next = null;
                } else {
                    prev.next = current.next;
                    current.next = null;
                }
                
                size--;
            }
            
            prev = current;
            current = current.next;
            
        }
        
    }
    
    private void delete(Node node) {
        
        Node prev = head;
        Node current = head;
        
        while (current != null) {
            if (current.id == node.id) {// there is a match
                
                if (current == head) {
                    head = current.next;
                    current.next = null;
                } else if (current == tail) {
                    tail = prev;
                    prev.next = null;
                } else {
                    prev.next = current.next;
                    current.next = null;
                }
                
                size--;
            }
            
            prev = current;
            current = current.next;
            
        }
        
    }
    
    public int size() {
        return size;
    }
    
    public void printNodes() {
        Node current = head;
        while (current != null) {
            System.out.println("Current id is -> " + current.id);
            current = current.next;
        }
        
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    
}

