package hash.separateChaining;

import edu.princeton.cs.algs4.SequentialSearchST;

import java.util.ArrayDeque;
import java.util.Queue;

public class separateChainingHash<K,V> {
    private int N;
    private int M;
    private SequentialSearchST<K,V>[] st;

    public separateChainingHash(int M) {
        this.M = M;
        st = new SequentialSearchST[M];
        for(int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<>();
    }
    public separateChainingHash() {
        this(997);
    }
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public V get(K key){
        return st[hash(key)].get(key);
    }
    public void put(K key, V val){
        st[hash(key)].put(key,val);
    }
    public Iterable<K> keys(){
        return keysQ();
    }
    private Queue<K> keysQ(){
        Queue<K> que = new ArrayDeque<>();
        for(SequentialSearchST<K,V> tempST : st)
            for(K tempK : tempST.keys())
                que.add(tempK);
        return que;
    }

    public static void main(String[] args){
        separateChainingHash<String,Integer> myH = new separateChainingHash<>(100);
        for(int i=0; i<100;i++)
            myH.put("str"+i,i);
        for(String tempK : myH.keys()){
           System.out.println("key: "+tempK+" value: "+myH.get(tempK));
        }
    }

}
