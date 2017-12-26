package Map61B;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.omg.CORBA.IRObject;

import java.util.Iterator;


import static org.junit.Assert.*;

/**
 * An array based implementation of the Map61B class.
 */
public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<K>  {
    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /** Returns the index of the given key if it exists,
     *  -1 otherwise. */
    private int keyIndex(K key) {
        for (int i = 0; i < size; i += 1) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    public Iterator<K> iterator(){
        return new KeyIterator();
    }

    public class KeyIterator implements Iterator<K>{
        private int curr_pos;

        public KeyIterator(){
            curr_pos = 0;
        }

        public boolean hasNext(){
            return (curr_pos < size);
        }

        public K next() {
           K result = keys[curr_pos];
           curr_pos ++;
           return result;
        }
    }

    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size += 1;
            return;
        }
        values[index] = value;
    }

    public V get(K key) {
        int index = keyIndex(key);
        return values[index];
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> keylist = new ArrayList<K>();
        for (int i = 0; i < keys.length; i += 1) {
            keylist.add(keys[i]);
        }
        return keylist;
    }

    @Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals((Integer) expected, am.get(2));
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
    }

    public static interface Map61B<K, V> {
        /* Returns true if this map contains a mapping for the specified key. */
        boolean containsKey(K key);

        /* Returns the value to which the specified key is mapped. No defined
         * behavior if the key doesn't exist (ok to crash). */
        V get(K key);

        /* Returns the number of key-value mappings in this map. */
        int size();

        /* Associates the specified value with the specified key in this map. */
        void put(K key, V value);

        /* Returns a list of the keys in this map. */
        List<K> keys();
    }
}
