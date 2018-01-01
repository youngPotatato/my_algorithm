package lab8;

import java.util.*;

public class BSTMap <K extends Comparable<K>,V> implements  Map61B<K,V> {

    private Node root;
    private class Node {
       private K key;
       private V val;
       private Node left,right;
       private int size;
       public Node(K key, V val, int size){
          this.key = key;
          this.val = val;
          this.size = size;
       }
    }

    @Override
    public void clear(){
       root = null;
    };

    @Override
    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
        return get(root,key);
    };

    private V get(Node root,K key){
       if(root == null)
           return null;
       int cmp = root.key.compareTo(key);
       if(cmp > 0) return get(root.left,key);
       else if(cmp < 0) return get(root.right,key);
       else return root.val;
    }

    @Override
    public void put(K key, V value){
        root = put(root, key, value);
    }

    private Node put(Node root, K key, V value){
        if(root == null)
            return new Node(key,value,1);
        int cmp = root.key.compareTo(key);
        if(cmp > 0) root.left = put(root.left,key,value);
        else if(cmp < 0) root.right = put(root.right,key,value);
        else root.val = value;
        root.size = size(root.left)+ size(root.right)+ 1;
        return root;
    }
    @Override
    public boolean containsKey(K key){
       return containsKey(root,key);
    }

    private boolean containsKey(Node root, K key){
       if(root == null)
           return false;
       int cmp = root.key.compareTo(key);
       if(cmp > 0) return containsKey(root.left,key);
       else if(cmp < 0) return containsKey(root.right,key);
       else return true;
    }


    @Override
    public int size(){
        return size(root);
    }
    private int size(Node root){
       if(root == null)  return 0;
       else return root.size;
    }


    public K min(){
        return min(root).key;
    }
    private Node min(Node root){
        if(root == null)
            return null;
        if(root.left == null)  return root;
        else return min(root.left);
    }


    private void deleteMin(){
        root = deleteMin(root);
    }
    private Node deleteMin(Node root){
        if(root == null) return null;
        if(root.left != null) {
            root.left = deleteMin(root.left);
            root.size = size(root.left) + size(root.right) + 1;
            return root;
        } else return root.right;
    }

     public void delete(K key){
        root = delete(root,key);
     }

    private Node delete(Node root, K key){
        if(root == null) return null;
        int cmp = root.key.compareTo(key);
        if(cmp > 0) root.left = delete(root.left,key);
        else if(cmp < 0) root.right = delete(root.right,key);
        else{
            if(root.left == null)  return root.right;
            if(root.right == null) return root.left;
            //Node t = min(root.right);
            //root.right = deleteMin(root.right);
            //t.right = root.right;
            //t.left = root.left;
            //root = t;
            Node t = root;
            root = min(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    @Override
    public V remove(K key){
        Node temp = new Node(key,null,0);
        root = remove(root,key,temp);
        return temp.val;
    }
    private Node remove(Node root,K key, Node newNode){
        if(root == null) return null;
        int cmp = root.key.compareTo(key);
        if(cmp > 0) root.left = remove(root.left,key,newNode);
        else if(cmp < 0) root.right = remove(root.right,key,newNode);
        else{
            newNode.val = root.val;
            if(root.left == null)  return root.right;
            if(root.right == null) return root.left;
            //Node t = min(root.right);
            //root.right = deleteMin(root.right);
            //t.right = root.right;
            //t.left = root.left;
            //root = t;
            Node t = root;
            root = min(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    @Override
    public V remove(K key,V val){
        Node temp = new Node(key,null,0);
        root = remove(root,key,val,temp);
        return temp.val;
    }

    private Node remove(Node root,K key,V val, Node newNode){
        if(root == null) return null;
        int cmp = root.key.compareTo(key);
        if(cmp > 0) root.left = remove(root.left,key,val,newNode);
        else if(cmp < 0) root.right = remove(root.right,key,val,newNode);
        else{
            if(root.val.equals(val)) {
                newNode.val = root.val;
                if (root.left == null) return root.right;
                if (root.right == null) return root.left;
                //Node t = min(root.right);
                //root.right = deleteMin(root.right);
                //t.right = root.right;
                //t.left = root.left;
                //root = t;
                Node t = root;
                root = min(t.right);
                root.right = deleteMin(t.right);
                root.left = t.left;
            }
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }
    public Iterator<K> iterator(){
        return new myKeyIterator();
    }

    private class myKeyIterator implements Iterator<K>{
        Queue<Node> myNodeQueue;
        public myKeyIterator(){
            myNodeQueue = new ArrayDeque<>();
            addAllNode(root,myNodeQueue);
        }
        private void addAllNode(Node x,Queue<Node> queue){
            if(x == null) return;
            addAllNode(x.left,queue);
            queue.add(x);
            addAllNode(x.right,queue);
            return;
        }

        public boolean hasNext() {
            return myNodeQueue.iterator().hasNext();
        }
        public K next(){
           return myNodeQueue.poll().key;
        }

    }

    public Iterable<K> keys(){
       return keys(root);
    }
    private Queue<K> keys(Node x){
        Queue<K> queue = new ArrayDeque<>();
        addKeys(queue,x);
        return queue;
    }
    private void addKeys(Queue<K> q, Node x){
        if(x == null) return;
        addKeys(q,x.left);
        q.add(x.key);
        addKeys(q,x.right);
        return;
    }
    public Iterable<K> keys(K hi, K lo){
       return keys(root,hi,lo);
    }
    private Queue<K> keys(Node x, K hi, K lo){
        Queue<K> queue = new ArrayDeque<>();
        addKeys(queue,x,hi,lo);
        return queue;
    }
    private void addKeys(Queue<K> q, Node x, K hi, K lo){
        if(x == null) return;
        int compLo = lo.compareTo(x.key);
        int compHi = hi.compareTo(x.key);
        if(compLo<0)addKeys(q,x.left,hi,lo);
        if(compLo<=0 && compHi >=0) q.add(x.key);
        if(compHi >0)addKeys(q,x.right,hi,lo);
        return;
    }

    @Override
    public Set<K> keySet(){
        return keySet(root);
    }
    private Set<K>  keySet(Node x){
        Set<K> set = new HashSet<>();
        addKeysToSet(set,x);
        return set;
    }
    private void addKeysToSet(Set<K> set, Node x){
        if(x == null) return;
        addKeysToSet(set,x.left);
        addKeysToSet(set,x.right);
        set.add(x.key);
        return;
    }
    public static void main(String [] args){
        BSTMap<String, Integer> aa = new BSTMap<>();
        aa.put("h",1);
        aa.put("k",1);
        aa.put("c",1);
        aa.put("e",1);
        aa.put("i",1);
        aa.put("j",1);
        aa.put("x",1);
        aa.put("b",1);
        aa.put("d",1);
        aa.put("f",1);
        aa.put("g",1);
        aa.put("m",1);
        System.out.println("size is " + aa.size());
        aa.delete("c");
        System.out.println("size is " + aa.size());
        System.out.println("key x --val is " + aa.remove("x"));
        System.out.println("size is " + aa.size());
        System.out.println("key m --val is " + aa.remove("m",2));
        System.out.println("size is " + aa.size());
        System.out.println("key m --val is " + aa.remove("m",1));
        System.out.println("size is " + aa.size());
        System.out.println("min key is " + aa.min());
        System.out.println("deleting min... " + aa.min());
        aa.deleteMin();
        System.out.println("size is " + aa.size());
        System.out.println("min key is " + aa.min());
        System.out.println("deleting min... " + aa.min());
        aa.deleteMin();
        System.out.println("size is " + aa.size());
        System.out.println("min key is " + aa.min());
        System.out.println("clearing... ");
        //aa.clear();
        //System.out.println("size is " + aa.size());
        Iterator<String> iter =  aa.iterator();
        System.out.println("a for loop ....");
        while(iter.hasNext()){
            System.out.println("Key is " + iter.next());
        }
        System.out.println("a for loop ....");
        for(String temp : aa.keys())
            System.out.println("Key is " + temp);
        System.out.println("deleting j");
        aa.delete("j");
        System.out.println("a for loop ....");
        for(String temp : aa.keys())
            System.out.println("Key is " + temp);
        System.out.println("deleting h");
        aa.delete("h");
        System.out.println("a for loop ....");
        for(String temp : aa.keys())
            System.out.println("Key is " + temp);
        System.out.println("deleting e");
        aa.delete("e");
        System.out.println("a for loop ....");
        for(String temp : aa.keys())
            System.out.println("Key is " + temp);
        System.out.println("keys between a and z ....");
        for(String temp : aa.keys("z","a"))
            System.out.println("Key is " + temp);
        System.out.println("keys between A and Z ....");
        for(String temp : aa.keys("Z","A"))
            System.out.println("Key is " + temp);
        System.out.println("keys between f and h ....");
        for(String temp : aa.keys("h","f"))
            System.out.println("Key is " + temp);
        System.out.println("keys between Z and A ....");
        for(String temp : aa.keys("A","Z"))
            System.out.println("Key is " + temp);
        System.out.println("keySet for loop ....");
        for(String temp : aa.keySet())
            System.out.println("Key is " + temp);
    }
}
