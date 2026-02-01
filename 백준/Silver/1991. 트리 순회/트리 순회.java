import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    Node(char value) {
        this.value = value;
    }
}

public class Main {
    static Node[] nodes = new Node[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            int parentIdx = parent - 'A'; // A->0, B->1...
            if (nodes[parentIdx] == null) {
                nodes[parentIdx] = new Node(parent);
            }
            if (left != '.') {
                int leftIdx = left - 'A';
                nodes[leftIdx] = new Node(left);
                nodes[parentIdx].left = nodes[leftIdx];
            }
            if (right != '.') {
                int rightIdx = right - 'A';
                nodes[rightIdx] = new Node(right);
                nodes[parentIdx].right = nodes[rightIdx];
            }
        }

        preorder(nodes[0]);
        System.out.println();
        inorder(nodes[0]);
        System.out.println();
        postorder(nodes[0]);
    }

    static void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}