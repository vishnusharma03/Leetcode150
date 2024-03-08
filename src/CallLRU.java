package src;

public class CallLRU {

    public static void main(String[] args) {

//        LRUCache obj = new LRUCache(2);

//        // Test case operations
//        System.out.println(obj.get(2)); // Output should be -1 (not found)
//        obj.put(2, 6);
//        obj.display(obj.head);
//        System.out.println(obj.get(1)); // Output should be -1 (not found)
//        obj.put(1, 5);
//        obj.display(obj.head);
//        obj.put(1, 2);
//        obj.display(obj.head);
//        System.out.println(obj.get(1)); // Output should be 2
//        System.out.println(obj.get(2));
        LRUCache obj = new LRUCache(2);

        obj.put(2, 1);
        obj.display(obj.head);

        obj.put(1, 1);
        obj.display(obj.head);

        obj.put(2, 3);
        obj.display(obj.head);

        obj.put(4, 1);
        obj.display(obj.head);

        int x = obj.get(1);
        System.out.println("1 Key " + x);

        int y = obj.get(2);
        System.out.println("2 Key "+ y);
//
//// Test 2
//        System.out.println("Test 2");
//
//        LRUCache obj2 = new LRUCache(2);
////        int p = obj2.get(2);
////        System.out.println("get 2 is " + p);
//
//        obj2.put(1, 1);
//        obj2.display(obj2.head);
//
//        obj2.put(2, 2);
//        obj2.display(obj2.head);
//
//        int a = obj2.get(1);
//        System.out.println("1 Key "+ a);
//
//        obj2.put(3, 3);
//        obj2.display(obj2.head);
//
//        int b = obj.get(2);
//        System.out.println("2 Key " + b);
//
//        obj2.put(4, 4);
//        obj2.display(obj2.head);
//
//
//        int c = obj2.get(1);
//        System.out.println("1 Key " + c);
//
//        int d = obj2.get(3);
//        System.out.println("3 Key "+ d);
//
//        int e = obj2.get(4);
//        System.out.println("4 Key " + e);
//
//        obj2.display(obj2.head);
    }
}



//public class DoublyLinkedList {
//    Node head;
//    Node tail;
//
//    class Node {
//        int value;
//        Node prev;
//        Node next;
//
//        Node(int value) {
//            this.value = value;
//        }
//    }
//}
    // Method to remove a node with a specific value
//    public void removeNodeWithValue(int value) {
//        Node current = head;
//
//        // Traverse the list to find the node with the given value
//        while (current != null) {
//            if (current.value == value) {
//                // Node to be removed is the head
//                if (current == head) {
//                    head = head.next;
//                    if (head != null) {
//                        head.prev = null;
//                    }
//                }
//                // Node to be removed is the tail
//                else if (current == tail) {
//                    tail = tail.prev;
//                    if (tail != null) {
//                        tail.next = null;
//                    }
//                }
//                // Node to be removed is in the middle
//                else {
//                    current.prev.next = current.next;
//                    current.next.prev = current.prev;
//                }
//                // Decrement the size if you maintain a size variable
//                // size--;
//                break;
//            }
//            current = current.next;
//        }
//    }

    // Additional methods like addNode, printList, etc., can be added here
//}

