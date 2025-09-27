class Solution{
    public Node deleteKeys(Node head, int x){
        if(head == null){
            return null;
        }

        while(head != null && head.data == x){
            head = head.next;
        }

        Node temp = head;
        Node prev = null;

        while(temp != null){
            if(temp.data == x){
                prev.next = temp.next;
            }else{
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}