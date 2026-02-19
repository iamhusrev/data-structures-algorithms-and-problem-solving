package com.nogayhusrev.cydeo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Node {
    
    
    int id;
    
    Node next;
    
    public Node(int id) {
        this.id = id;
    }
    
}
