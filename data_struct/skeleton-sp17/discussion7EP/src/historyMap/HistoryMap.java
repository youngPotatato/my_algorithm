package historyMap;
import java.util.HashMap;
import java.util.Stack;

public class HistoryMap<K,V> extends HashMap<K,V> {

    private Stack<op> HS = new Stack<>();

    class op {
        K key;
        V value;
        boolean shouldBeRestored;
        public op(boolean sbr, K k,V v) {
            key = k;
            value = v;
            shouldBeRestored = sbr;
        }
    }

    @Override
    public V put(K key, V value){
        HS.push(new op(super.containsKey(key),key,super.get(key)));
        return super.put(key,value);
    }
    @Override
    public V remove(Object key){
        HS.push(new op(true,(K)key,super.get(key)));
        return super.remove(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key);
    }

    public void undo(){
        if(HS.empty())
            return;
        op historyOP = HS.pop();
        if(historyOP.shouldBeRestored){//last op should be restored to hashmap
            super.put(historyOP.key,historyOP.value);
        } else{//last op shouldn't be restored
            super.remove(historyOP.key);
        }

    }

    public static void main(String[] args) {
       HistoryMap<String, Integer>  h = new HistoryMap<>();
       h.put("party",1);
       h.put("parrot",2);
       h.put("conga",4);
        h.put("parrot",3);
        h.put("parrot",4);
        h.put("conga",1);
        h.put("parrot",5);
        //debug
        System.out.println(h);
        System.out.println();
        System.out.println();
        h.undo();
        h.undo();
        System.out.println(h);
        System.out.println();
        System.out.println();

        h.undo();
        h.undo();
        h.undo();
        System.out.println(h);
        System.out.println();
        System.out.println();
        h.remove("party");
        h.undo();
        System.out.println(h);
    }
}
