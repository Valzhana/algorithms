package seminar_4;


public class HashTable<K, V> {
    private static final int initBasketCount = 16;
    private static final double loadFactor = 0.75;
    private int size = 0;
    private void recalculate() {
        basket[] old = baskets;
        baskets = (basket[]) new Object[old.length * 2];
        for (int i = 0; i <= old.length; i++) {
            basket bask = old[i];
            basket.Node newNode = bask.head;
            while ( (newNode != null)) {
                put(newNode.value.key, newNode.value.value);
                newNode = newNode.next;
            }
            old[i] = null;
        }
    }
    private basket[] baskets;

    public HashTable() {
        this(initBasketCount);
    }
    public HashTable(int initSize) {
        baskets = (basket[]) new Object[initSize];
    }
    private int calculateBasketIndex(K key) {
        return key.hashCode() % baskets.length;
    }
    private class Entity {
        private K key;
        private V value;
    }
    private class basket {
        private Node head;
        private class Node {
            private Node next;
            private Entity value;
        }
        public V getBasket(K key) {
            Node item = head;
            while (item != null) {
                if (item.value.key.equals(key)) {
                    return item.value.value;
                }
                item = item.next;
            }
            return null;
        }
        public boolean put(Entity entity) {
            Node node = new Node();
            node.value = entity;
            Node item = head;
            if (item != null) {
                while (true) {
                    if (item.value.key.equals(entity.key)) {
                        return false;
                    }
                    if (item.next == null) {
                        item.next = node;
                        return true;
                    }
                    item = item.next;
                }
            }
            head = node;
            return true;
        }
        public boolean remove(K key) {
            if (head != null) {
                if (head.value.key.equals(key)) {
                    head = head.next;
                    return true;
                } else {
                    Node node = head;
                    while (node.next != null) {
                        if (node.value.key.equals(key)) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }
                }

            }
            return false;
        }
    }
    public V getBasketOut(K key) {
        int index = calculateBasketIndex(key);
        basket basket = baskets[index];
        if (basket != null) {
            return basket.getBasket(key);
        }
        return null;
    }
    public boolean put(K key, V value) {
        if (baskets.length * loadFactor < size) {
            recalculate();
        }
        int index = calculateBasketIndex(key);
        basket bask = baskets[index];
        if (bask == null) {
            bask = new basket();
            baskets[index] = bask;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        boolean add = bask.put(entity);
        if (add) {
            size++;
        }
        return add;
    }
    public boolean removeOut(K key) {
        int index = calculateBasketIndex(key);
        basket bask = baskets[index];
        boolean delete = bask.remove(key);
        if (delete) {
            size--;
        }
        return delete;
    }
}
