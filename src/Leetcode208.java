package src;

public class Leetcode208 {
    public static void main(String[] args) {

    }
}

class Node {
    private static final int len = 26;
    private Node[] one;
    private boolean isEnd;

    public Node(){
        one = new Node[len];
        isEnd = false;
    }

    public boolean containsKey(char ch){
        return one[ch - 'a'] != null;
    }

    public Node get(char ch){
        return one[ch - 'a'];
    }

    public void put(char ch, Node newnode){
        one[ch - 'a'] = newnode;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean getEnd(){
        return isEnd;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()){
            if (!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node tNode = searchPrefix(word);
        return tNode!=null && tNode.getEnd();
    }

    public boolean startsWith(String prefix) {
        Node tNode = searchPrefix(prefix);
        return tNode!=null;
    }

    public Node searchPrefix(String Prefix){
        Node node = root;
        for (char ch : Prefix.toCharArray()){
            if (node.containsKey(ch)){
                node = node.get(ch);
            }
            else return null;
        }
        return node;
    }
}

