class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution{
    public void solve(Node head){
        if(head == null || head.next == null){
            return;
        }

        Node slow = head;
        Node fast = head;
        boolean cycle= false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        slow = head;
        Node prev = null;

        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }
}