package hash;

import java.util.*;

class Pair<U, V> {
    public U key;
    public V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class LeetCode706 {

    private List<Pair<Integer, Integer>> list;

    public LeetCode706() {
        this.list = new LinkedList<Pair<Integer, Integer>>();
    }

    public void put(int key, int value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair : this.list) {
            if (pair.key.equals(key)) {
                pair.value = value;
                found = true;
                break;
            }
        }
        if (!found)
            this.list.add(new Pair<>(key, value));
    }

    public int get(int key) {
        for (Pair<Integer, Integer> pair: this.list) {
            if (pair.key.equals(key))
                return pair.value;
        }
        return -1;
    }

    public void remove(int key) {
        for (Pair<Integer, Integer> pair : this.list) {
            if (pair.key.equals(key)){
                this.list.remove(pair);
                break;
            }
        }
    }

    public static void main(String[] args) {

    }
}
