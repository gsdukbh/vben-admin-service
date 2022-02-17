package top.werls.vben.common.utils.cache.impl;

import java.io.Serial;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2021/10/7
 */
public class SimpleCache<K, V> extends AbstractCache<K, V> {
    @Serial
    private static final long serialVersionUID = 575086311006109930L;

    /**
     * 一个简单的缓冲 ConcurrentHashMap 实现
     * @param capacity 缓冲容量 默认0 无限大小
     */
    public SimpleCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 一个简单的缓冲 ConcurrentHashMap 实现
     * @param capacity 缓冲容量 默认 0 无限大小
     * @param timeout 过期时间
     */
    public SimpleCache(int capacity, long timeout) {
        this.capacity = capacity;
        this.timeout = timeout;
        cacheMap = new ConcurrentHashMap<>(capacity + 1, 1.0f);
    }
}
