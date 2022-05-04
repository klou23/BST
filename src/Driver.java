/**
 * Driver.java
 * Kevin Lou
 * 05/03/2022
 * Driver class for testing BinarySearchTree
 */

public class Driver {

    /**
     * Tests BinarySearchTree class.
     * Should print:
     * Size: 0
     * Is Empty: true
     * Get "a": 1
     * Get "b": 2
     * Contains "a": true
     * Contains "c": true
     * Contains "b": false
     * Min key: "a"
     * Max key: "f"
     * BST: {a=1, c=3, d=4, e=5, f=6}
     */
    public static void main(String[] args) {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
        System.out.printf("Size: %d\n", bst.size());
        System.out.printf("Is Empty: %b\n", bst.isEmpty());
        bst.put("a", 1);
        bst.put("b", 2);
        bst.put("d", 4);
        bst.put("e", 5);
        bst.put("c", 3);
        System.out.printf("Get \"a\": %d\n", bst.get("a"));
        System.out.printf("Get \"b\": %d\n", bst.get("b"));
        System.out.printf("Contains \"a\": %b\n", bst.contains("a"));
        System.out.printf("Contains \"c\": %b\n", bst.contains("c"));
        bst.remove("b");
        bst.put("f", 6);
        System.out.printf("Contains \"b\": %b\n", bst.contains("b"));
        System.out.printf("Min key: \"%s\"\n", bst.min());
        System.out.printf("Max key: \"%s\"\n", bst.max());
        System.out.printf("BST: %s", bst.toString());
    }

}
