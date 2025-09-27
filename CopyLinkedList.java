class Node {
    int data;
    Node next;
    Node random;

    Node() {
        data = 0;
        next = null;
        random = null;
    }

    Node(int data) {
        this.data = data;
        next = null;
        random = null;
    }

    Node(int data, Node next, Node random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}

class Solution {
    public void insertNodesBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }

    public void connectRandom(Node head) {
        Node temp = head;

        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }

            temp = temp.next.next;
        }
    }

    public Node getDeepCopy(Node head) {
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;

        while (temp != null) {
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        insertNodesBetween(head);
        connectRandom(head);
        return getDeepCopy(head);
    }
}