package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// Leetcode380
class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // 2
    }

    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int RemoveIdx = map.get(val);
            int lastElement = list.get(list.size()-1);
            list.set(RemoveIdx,lastElement);
            map.put(lastElement, RemoveIdx);
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
