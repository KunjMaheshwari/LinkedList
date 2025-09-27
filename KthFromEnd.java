class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution{
    public int solve(Node head, int k){
        // kth node from the end will be size-kth node from the front

        int size = 0;
        Node temp = head;

        if(head == null){
            return -1;
        }

        while(temp != null){
            temp = temp.next;
            size++;
        }

        if(k > size){
            return -1;
        }

        temp = head;
        int n = size - k;

        for(int i=0;i<n;i++){
            temp = temp.next;
        }
        return temp.data;
    }
}