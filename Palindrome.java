class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public Node middle(Node head){
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(Node head) {
        // code here
        if(head == null || head.next == null){
            return true;
        }
        
        Node midNode = middle(head);
        
        Node prev = null;
        Node curr = midNode;
        Node next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        Node left = head;
        Node right = prev;
        
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            
            left = left.next;
            right = right.next;
        }
        
        return true;
        
    }
}