class TimeMap {
    HashMap<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair<Integer, String> pair = new Pair<>(timestamp, value);
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());
        list.add(pair);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            List<Pair<Integer, String>> list = map.get(key);
            String res = "";
            int start = 0, end = list.size()-1;
            while(start<=end) {
                int mid = start+(end-start)/2;
                if(list.get(mid).getKey() == timestamp) {
                    return list.get(mid).getValue();
                }
                if(list.get(mid).getKey() < timestamp) {
                    res = list.get(mid).getValue();
                    start = mid+1;
                } else if(list.get(mid).getKey() > timestamp) {
                    end = mid-1;
                }
            }
            return res;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */