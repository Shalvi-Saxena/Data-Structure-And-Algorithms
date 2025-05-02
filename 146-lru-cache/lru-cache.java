class LRUCache {
    HashMap<Integer, Integer> map;
    List<Integer> keys;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        keys = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            keys.remove(Integer.valueOf(key));
            keys.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            keys.remove(Integer.valueOf(key));
            map.remove(key);
        } else if(keys.size() == capacity){
            map.remove(keys.get(0));
            keys.remove(0);
        }
        map.put(key, value);
        keys.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */