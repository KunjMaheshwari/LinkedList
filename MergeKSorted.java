class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {

    public Node mergeSorted2LL(Node head1, Node head2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            
            temp = temp.next;
        }

        //remaining elements
        if(head1 != null){
            temp.next = head1;
        }

        if(head2 != null){
            temp.next = head2;
        }

        return dummyNode.next;
    }

    public Node mergeKList(Node arr[]) {
        Node head = arr[0];

        for (int i = 1; i < arr.length; i++) {
            head = mergeSorted2LL(head, arr[i]);
        }

        return head;

    }
}