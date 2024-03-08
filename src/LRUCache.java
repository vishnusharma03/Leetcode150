package src;
// Leetcode 146

import java.util.HashMap;

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.key + ":" + temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

//class LRUCache {
//    private int capacity;
//    private ListNode last;
//    public ListNode head;
//    private ListNode tail;
//    private int size;
//
//    private void ListNode() {
//        this.size = 0;
//    }
//
//    private HashMap<Integer, Integer> map;
//
//    public class ListNode {
//
//        private int val;
//        ListNode next;
//        ListNode prev;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//            this.next = null;
//            this.prev = null;
//        }
//
//        ListNode(int val, ListNode next, ListNode prev) {
//            this.val = val;
//            this.next = next;
//            this.prev = prev;
//        }
//
//    }
//
//    public void display(ListNode X) {
//        ListNode currentNode = X;
//        while (currentNode != null) {
//            System.out.print(currentNode.val + " ");  // Print the current node's value
//            currentNode = currentNode.next;  // Move to the next node
//        }
//        System.out.println();
//    }
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>(capacity);
//    }
//
//    public int get(int key) {
//        if (map.isEmpty() || !map.containsKey(key))
//            return -1;
//
//        if (last.prev != null) {
//            last = last.prev;
//        } else if (last.next !=null) last = last.next;
//        return map.get(key);
//    }
//
//    public void put(int key, int value) {
//        if (size == capacity) {
//            if (last.val == key) {
//                System.out.println("Last Node is at " + last.val);
//                map.remove(last.val);
//
//                if (last.prev != null) {
//                    last.prev.next = last.next;
//                } else {
//                    head = last.next;
//                }
//
//                if (last.next != null) {
//
//                    last.next.prev = last.prev;
//                } else {
//                    tail = last.prev;
//                }
//                size--;
//                if (last.next != null) {
//                    last = last.next;
//                } else if (last.prev != null) {
//                    last = last.prev;
//                }
//            }else {
//                ListNode current = head;
//
//                // Traverse the list to find the node with the given value
//                while (current != null) {
//                    if (current.val == key) {
//                        // Node to be removed is the head
//                        if (current == head) {
//                            head = head.next;
//                            if (head != null) {
//                                head.prev = null;
//                            }
//                        }
//                        // Node to be removed is the tail
//                        else if (current == tail) {
//                            tail = tail.prev;
//                            if (tail != null) {
//                                tail.next = null;
//                            }
//                        }
//                        // Node to be removed is in the middle
//                        else {
//                            current.prev.next = current.next;
//                            current.next.prev = current.prev;
//                        }
//                        // Decrement the size if you maintain a size variable
//                        size--;
//                        break;
//                    }
//                    current = current.next;
//                }
//            }
//        }
//        if (tail == null && head == null) {
//            ListNode node = new ListNode(key);
//            head = node;
//            tail = node;
//            last = node;
//            size++;
//            map.put(key, value);
//        } else {
//            ListNode node = new ListNode(key);
//            node.next = head;
//            head.prev = node;
//            head = node;
//            map.put(key, value);
//            size++;
//        }
//    }
//
//    private boolean keyisPresent(int key) {
//        if (map.containsKey(key))
//            return true;
//        return false;
//    }
//}





//    public void put(int key, int value) {
//        if (tail == null && head == null) {
//            ListNode node = new ListNode(key);
//            head = node;
//            tail = node;
//            last = node;
//            size++;
//            map.put(key, value);
//        } else {
//
//            if (size == capacity) {
//                System.out.println("Last Node is at " + last.val);
//                map.remove(last.val);
//
//                if (last.prev != null) {
//                    last.prev.next = last.next;
//                } else {
//                    // 'last' was the head of the list, update the head
//                    head = last.next;
//                }
//
//                if (last.next != null) {
//                    last.next.prev = last.prev;
//                } else {
//                    // 'last' was the tail of the list, update the tail
//                    tail = last.prev;
//                }
////                if ()
//                size--;
//            }
//            ListNode node = new ListNode(key);
//            node.next = head;
//            head.prev = node;
//            head = node;
//            map.put(key, value);
//            size++;
//        }
//    }
//}

//    public static void main(String[] args) {
//        LRUCache obj = new LRUCache(2);
//        obj.put(1, 1);
//        obj.display(obj.head);
//
//        obj.put(2, 2);
//        obj.display(obj.head);
//
//        int a = obj.get(1);
//        System.out.println("1 Key "+ a);
//
//        obj.put(3, 3);
//        obj.display(obj.head);
//
//        int c = obj.get(2);
//        System.out.println("2 Key " + c);
//
//        obj.put(4, 4);
//        obj.display(obj.head);
//
//        int b = obj.get(1);
//        System.out.println("1 Key " + b);
//
//        int d = obj.get(3);
//        System.out.println("3 Key "+ d);
//
//        int e = obj.get(4);
//        System.out.println("4 Key " + e);
//
//        obj.display(obj.head);
//    }

//}

