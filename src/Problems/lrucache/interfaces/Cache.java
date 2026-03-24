package Problems.lrucache.interfaces;

public interface Cache <T, V> {
    V getKey(T key);
    void put(T key, V value);
    void remove(T key);
    void setEvictionPolicy(EvictionPolicy policy);
    void clear();
}
