/**
 * BinarySearchTree.java
 * Kevin Lou
 * 05/03/2022
 * Implementation of BST.
 * Template provided by Ms. Hellman.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public Node<Key, Value> root;

    public BinarySearchTree() {}

    public int size() {
        return size(root);
    }

    //use Node's recursive size
    private int size(Node x) {
        if(x == null) return 0;
        return 1 + size(x.getLeft()) + size(x.getRight());
    }

    public boolean isEmpty() {
        return root == null;
    }

    //recursive put wrapper
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //recursive put
    //sets left/right or creates a new node appropriately, returns the
    //modified node n
    private Node<Key, Value> put(Node<Key, Value> n, Key key, Value val) {
        if(n == null) return new Node<>(key, val, 1);

        if(n.getKey().compareTo(key) > 0){
            n.setLeft(put(n.getLeft(), key, val));
        }else if(n.getKey().compareTo(key) < 0){
            n.setRight(put(n.getRight(), key, val));
        }

        return n;
    }

    //recursive get wrapper
    public Value get(Key key) {
        return get(root, key);
    }

    //recursive get
    //returns null if the key does not exist
    private Value get(Node<Key, Value> n, Key key) {
        if(n == null) return null;
        if(n.getKey().compareTo(key) == 0) return n.getValue();
        else if(n.getKey().compareTo(key) > 0) return get(n.getLeft(), key);
        else return get(n.getRight(), key);
    }

    public boolean contains(Key key) {
        return get(root, key) != null;
    }

    public Value remove(Key key) {
        Value v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node<Key, Value> n, Key key) {
        if (n == null) return null;
        int i = key.compareTo(n.getKey());
        if (i < 0) {
            n.setLeft(remove(n.getLeft(), key));
        } else if (i > 0) {
            n.setRight(remove(n.getRight(), key));
        } else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node min = min(n.getRight());
            min.setLeft(n.getLeft());
            n = n.getRight();
        }
        n.setSize(size(n.getRight()) + size(n.getLeft()) + 1);
        return n;
    }

    public Key min() {
        return min(root).getKey();
    }

    //returns the node at the left most left branch of n
    private Node<Key, Value> min(Node<Key, Value> n) {
        while(n.getLeft() != null) n = n.getLeft();
        return n;
    }

    public Key max() {
        return max(root).getKey();
    }

    //returns the node at the right most right branch of n
    private Node<Key, Value> max(Node<Key, Value> n) {
        while(n.getRight() != null) n = n.getRight();
        return n;
    }

    public String toString() {
        String temp = toString(root);
        temp = temp.substring(0, temp.length() - 2);
        return "{" + temp + "}";
    }

    private String toString(Node<Key, Value> n) {
        if (n == null) return "";
        return toString(n.getLeft()) +
                n.getKey() + "=" + n.getValue() + ", " +
                toString(n.getRight());

    }
}