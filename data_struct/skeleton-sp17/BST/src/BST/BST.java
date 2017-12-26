package BST;

import java.util.Iterator;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key k, Value v, int n) {
            this.key = k;
            this.val = v;
            this.N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else
            return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) { // Return value associated with key
        // in the subtree rooted at x;
        // return null if key not present in subtree rooted at x.
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        // Change key’s value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
       return max(root) .key;
    }

    private Node max(Node x){
       if(x.right == null)  return x;
       return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        // Return Node containing key of rank k.
        // if (x == null) return null; int t = size(x.left); if
        return x;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void delete(Key key) { root = delete(root, key); }
    private Node delete(Node x, Key key) {
        try {
            if (x == null)
                return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                if (x.right == null)
                    return x.left;
                Node t = min(x.right);
                t.right = deleteMin(x.right);
                t.left = x.left;
                x = t;
            }
            if (cmp < 0)
                x.left = delete(x.left, key);
            if (cmp > 0)
                x.right = delete(x.right, key);
            x.N = size(x.left) + size(x.right) + 1;
        }catch(Exception e){
            int xx = 0;
        }
            //if (x == null) return null;
            //int cmp = key.compareTo(x.key);
            //if (cmp < 0) x.left = delete(x.left, key);
            //else if (cmp > 0) x.right = delete(x.right, key);
            //else {
            //    if (x.right == null) return x.left;
            //    if (x.left == null) return x.right;
            //    Node t = x;
            //    x = min(t.right); // See page 407.
            //    x.right = deleteMin(t.right);
            //    x.left = t.left;
            //}
            //x.N = size(x.left) + size(x.right) + 1; return x;
        return x;
    }
    //public Iterable<Key> key(){
    //    return keys(min(),max());
    //}
    public static void main(String[] args){
        BST<String,Integer> myT = new BST<String,Integer>();
        myT.put("k",1);
        myT.put("q",1);
        myT.put("p",1);
        myT.put("m",1);
        myT.put("o",1);
        myT.put("n",1);
        myT.put("s",1);
        //myT.put("r",1);
        myT.put("y",1);
        myT.put("v",1);
        myT.put("u",1);
        myT.put("z",1);
        myT.put("u",1);
        myT.delete("s");
        int x = 0;
    }
}
