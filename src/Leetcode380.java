package src;

import java.util.*;

public class Leetcode380 {
    public static void main(String[] args) {

    }
    private ArrayList<String> list;
    private Set<String> map;
    private Random random;
    public void RandomizedSet() {
        list = new ArrayList<String>();
        map = new HashSet<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!map.contains(val)){
            map.add(String.valueOf(val));
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.contains(val)){
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom(Set<Integer> map) {
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
