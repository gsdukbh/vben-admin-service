package top.werls.vben.common.utils.cache;

import top.werls.vben.common.utils.cache.impl.SimpleCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存工具
 *
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/29
 */
public class CacheUtils {
    /**
     * 利用ConcurrentHashMap 实现简单的全局缓存
     */
    private static Map<String, Object> cache = new ConcurrentHashMap<>();


    /**
     * SimpleCache 默认100大小，60s缓存时间
     */
    public static Cache<Object, Object> simpleCache = new SimpleCache<>(20, 60 * 1000);

    public static <K, V> SimpleCache<K, V> simple(int capacity, long timeout) {
        return new SimpleCache<>(capacity, timeout);
    }

    public static <K, V> SimpleCache<K, V> simple(int capacity) {
        return new SimpleCache<>(capacity);
    }

}
