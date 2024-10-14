package lab3;

import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private int countBucket;
    private LinkedList<K> keyList = new LinkedList<>();

    public HashTable() {
        countBucket = 5;
        table = new LinkedList[countBucket];
        size = 0;
    }

    public int hash(K key, int countBucket) {
        int hashKey = key.hashCode();
        int index = hashKey % countBucket;
        return (index < 0) ? index * (-1) : index;
    }

    public void put(K key, V value) {
        if (size() == countBucket) {
            LinkedList<Entry<K, V>>[] tableNew;
            tableNew = new LinkedList[countBucket * 2];
            for (K keyA : keyList) {
                int index = hash(keyA, countBucket * 2);
                if (tableNew[index] == null) {
                    tableNew[index] = new LinkedList<>();
                }
                tableNew[index].add(new Entry<>(keyA, get(keyA)));
            }

            table = tableNew;
            countBucket *= 2;
        }

        int index = hash(key, countBucket);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        keyList.add(key);
        size++;
    }

    public V get(K key) {
        int index = hash(key, countBucket);
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key, countBucket);
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                keyList.remove(key);
                size--;
                return;
            }
        }
    }

    public Object getDataAtIndex(K key) {
        int index = hash(key, countBucket);
        if (table[index] == null) {
            return null;
        }
        return table[index].size();
    }

    public int getIndex(K key) {
        return hash(key, countBucket);
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}
