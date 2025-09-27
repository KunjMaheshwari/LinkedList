class Solution{
    public void solution(Node del_Node){
        if(del_Node == null || del_Node.next == null){
            return;
        }

        del_Node.data = del_Node.next.data;
        del_Node.next = del_Node.next.next;
    }
}