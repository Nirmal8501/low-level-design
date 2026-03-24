package Problems.lrucache.interfaces;

public interface EvictionPolicy {
    void evict(Cache cache);
}
