package basicdatastructures;

public class BinaryTree {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }
    public BinaryTree() {}

    public Node find(int value) {
        Node current = root;

        while (current != null) {
            if (value > current.value) {
                current = current.right;
            }
            else if (value < current.value) {
                current = current.left;
            }
            else break;
        }
        return current;
    }
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while(true) {
            if (node.value > current.value) {
                if (current.right == null) {
                    current.right = node;
                    return;
                }
                current = current.right;
            }
            else {
                if (current.left == null) {
                    current.left = node;
                    return;
                }
                current = current.left;
            }
        }
    }
    public void remove(int value) {
        Node node = find(value);
        if (node == null) return;

        if (node.left != null && node.right == null) {
            node = node.left;
            return;
        }
        else if (node.right != null && node.left == null) {
            node = node.right;
            return;
        }
        // two child

        node.value = getSuccessor(node);
    }
    public int getSuccessor(Node node) {
        Node successor = node.right;
        Node successorParent = node;

        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successorParent == node) successorParent.right = null;
        else successorParent.left = null;

        return successor.value;
    }
    public static int COUNT = 10;
    public void print2DUtil(Node root, int space) {
        // Base case
        if (root == null) return;
    
        // Increase distance between levels
        space += COUNT;
    
        // Process right child first
        print2DUtil(root.right, space);
    
        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");
    
        // Process left child
        print2DUtil(root.left, space);
    }

    public void print2D() {
        print2DUtil(root, 0);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(12);
        tree.insert(11);
        tree.insert(13);
        tree.insert(54);
        tree.insert(23);
        tree.insert(2);
        tree.insert(3);
        tree.insert(8);
        tree.insert(-6);

        tree.print2D();

        tree.remove(10);

        System.out.println();

        tree.print2D();        
    }
}
