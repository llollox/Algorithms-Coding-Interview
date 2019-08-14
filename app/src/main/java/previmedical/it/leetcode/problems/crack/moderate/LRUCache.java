package previmedical.it.leetcode.problems.crack.moderate;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class LRUCache {

    public static class CacheKey {
        private int key;
        private long timestamp;

        public CacheKey(int key, long timestamp) {
            this.key = key;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return key == cacheKey.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    private HashMap<Integer, String> map = new HashMap<>();
    private Comparator<CacheKey> comparator = new Comparator<CacheKey>() {
        @Override
        public int compare(CacheKey ck1, CacheKey ck2) {
            return Long.compare(ck1.timestamp, ck2.timestamp);
        }
    };

    private PriorityQueue<CacheKey> queue = new PriorityQueue<>(this.comparator);
    private int maxSize;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public String getValue(int key) {
        String value = this.map.get(key);

        if (value != null) { // Update priority of key to now
            this.queue.remove(new CacheKey(key, 1));
            this.queue.add(new CacheKey(key, System.currentTimeMillis()));
        }

        return value;
    }

    public void insert(int key, String value) {
        if (this.maxSize == this.map.size()) {
            CacheKey peek = this.queue.poll();
            this.map.remove(peek.key);
        }

        this.map.put(key, value);
        CacheKey ck = new CacheKey(key, System.currentTimeMillis());
        this.queue.add(ck);
    }
}

