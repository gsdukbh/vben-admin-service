package top.werls.vben.common.utils.cache.impl;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/30
 */
public class CacheObject<K, V> implements Serializable {
    @Serial
    private static final long serialVersionUID = 318082012087507254L;

    private final K key;

    private final V value;

    /**
     * 过期时间，0 为永久
     */
    private final long timeout;

    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 访问次数
     */
    private final AtomicLong accessCount = new AtomicLong();

    public CacheObject(K key, V value, long timeout) {
        this.key = key;
        this.value = value;
        this.timeout = timeout;
        this.createTime = System.currentTimeMillis();
    }

    /**
     * 获取 key
     *
     * @return 键
     */
    public K getKey() {
        return key;
    }

    /**
     * 获取值
     *
     * @return 值
     */
    public V getValue() {
        return value;
    }

    /**
     * 是否过期
     * @return 过期 ture 否则，false
     */
    public boolean isExpired() {
        if (this.timeout > 0) {
            return (System.currentTimeMillis() - this.createTime) > this.timeout;
        }
        return false;
    }

    /**
     * 获取值，并且是否更新最后的时间
     *
     * @param isUpdateLastAccess 是否更新
     * @return 值
     */
    protected V get(boolean isUpdateLastAccess) {
        if (isUpdateLastAccess) {
            this.createTime = System.currentTimeMillis();
        }
        this.accessCount.incrementAndGet();
        return this.value;
    }

    @Override
    public String toString() {
        return "CacheObject{" +
                "key=" + key +
                ", value=" + value +
                ", timeout=" + timeout +
                ", createTime=" + createTime +
                ", accessCount=" + accessCount +
                '}';
    }
}
