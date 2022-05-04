public class Driver {

    public static void main(String[] args) {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
        System.out.printf("Size: %d\n", bst.size());
        System.out.printf("Is Empty: %b\n", bst.isEmpty());
        bst.put("a", 1);
        bst.put("b", 2);
        System.out.printf("Get \"a\": %d\n", bst.get("a"));
        System.out.printf("Get \"b\": %d\n", bst.get("b"));
        System.out.printf("Contains \"a\": %b\n", bst.contains("a"));
        System.out.printf("Contains \"c\": %b\n", bst.contains("c"));
        bst.remove("b");
        bst.put("c", 3);
        System.out.printf("Contains \"b\": %b\n", bst.contains("b"));
        System.out.printf("Min key: \"%s\"\n", bst.min());
        System.out.printf("Max key: \"%s\"\n", bst.max());
        System.out.printf("BST: %s", bst.toString());
    }

}
