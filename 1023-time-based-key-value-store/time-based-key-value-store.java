class TimeMap {
    class Entry {
        String value;
        int timestamp;
        Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    HashMap<String, List<Entry>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list = map.getOrDefault(key, new ArrayList<>());
        int left=0, right=list.size()-1;
        String value="";

        while(left<=right) {
            int mid = left + ((right-left)/2);
            Entry item = list.get(mid);
            if(item.timestamp == timestamp) {
                return item.value;
            } else if(item.timestamp < timestamp) {
                left = mid+1;
                value = item.value;
            } else {
                right = mid-1;
            }
        }

        return value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */