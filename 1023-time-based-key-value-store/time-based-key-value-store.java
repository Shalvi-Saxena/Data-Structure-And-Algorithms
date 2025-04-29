class TimeMap {
    static class Entry {
        int time;
        String value;
        Entry(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }

    HashMap<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Entry> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String res = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time == timestamp)
                return list.get(mid).value;
            else if (list.get(mid).time < timestamp) {
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
