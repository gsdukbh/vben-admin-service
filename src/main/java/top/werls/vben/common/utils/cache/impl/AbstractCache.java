package top.werls.vben.common.utils.cache.impl;



import top.werls.vben.common.utils.cache.Cache;

import java.io.Serial;
import java.util.Iterator;
import java.util.Map;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2021/10/7
 */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    @Serial
    private static final long serialVersionUID = 958362309219567308L;

    protected Map<K, CacheObject<K, V>> cacheMap;

    protected CacheListener<K, V> listener;

    /**
     * 缓存失效时长， {@code 0} 表示无限制，单位毫秒
     */
    protected long timeout;
    /**
     * 返回缓存容量，{@code 0}表示无大小限制
     */
    protected int capacity;

    /**
     * 每个对象是否有单独的失效时长，用于决定清理过期对象是否有必要。
     */
    protected boolean existCustomTimeout;

    /**
     * 将对象添加到缓冲中，默认超时时间
     *
     * @param key    键值
     * @param object 缓冲对象
     */
    @Override
    public void put(K key, V object) {
        put(key, object, this.timeout);
    }

    /**
     * 将对象添加到缓冲中，设置超时时间
     *
     * @param key     键
     * @param object  值
     * @param timeout 超时
     */
    @Override
    public void put(K key, V object, long timeout) {
        CacheObject<K, V> cc = new CacheObject<>(key, object, timeout);
        if (timeout != 0) {
            existCustomTimeout = true;
        }
        if (isFull()) {
            clear();
        }
        cacheMap.put(key, cc);
    }

    /**
     * 是否包含key
     *
     * @param key KEY
     * @return 是否包含key
     */
    @Override
    public boolean containsKey(K key) {
        final CacheObject<K, V> co = cacheMap.get(key);
        if (co == null) {
            return false;
        }
        if (!co.isExpired()) {
            return true;
        }
        remove(key);
        return false;
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return 返回值 V
     */
    @Override
    public V get(K key) {
        final CacheObject<K, V> co = cacheMap.get(key);
        if (co == null) {
            return null;
        }
        if (!co.isExpired()) {
            return co.get(false);
        }
        remove(key);
        return null;
    }

    /**
     * 移除对象
     *
     * @param key 键
     */
    @Override
    public void remove(K key) {
        CacheObject<K, V> co = cacheMap.remove(key);
        if (co != null) {
            onRemove(co.getKey(), co.getValue());
        }
    }

    /**
     * 对象移除回调。默认无动作<br>
     * 子类可重写此方法用于监听移除事件，如果重写，listener将无效
     *
     * @param key          键
     * @param cachedObject 被缓存的对象
     */
    protected void onRemove(K key, V cachedObject) {
        final CacheListener<K, V> listener = this.listener;
        if (null != listener) {
            listener.onRemove(key, cachedObject);
        }
    }

    /**
     * 缓冲大小
     *
     * @return 缓冲的中大小
     */
    @Override
    public int size() {
        return cacheMap.size();
    }

    /**
     * 返回缓存是否满
     *
     * @return 缓存是否满
     */
    @Override
    public boolean isFull() {
        return (capacity > 0) && (size() >= capacity);
    }

    /**
     * 返回缓存容量，{@code 0}表示无大小限制
     *
     * @return 返回缓存容量，{@code 0}表示无大小限制
     */
    @Override
    public int capacity() {
        return this.capacity;
    }

    /**
     * 缓存是否空
     *
     * @return 缓存是否为空
     */
    @Override
    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    /**
     * 清除缓存
     */
    @Override
    public void clear() {
        cacheMap.clear();
    }

    /**
     * 缓存失效时长， {@code 0} 表示没有设置，单位毫秒
     *
     * @return 缓存失效时长， {@code 0} 表示没有设置，单位毫秒
     */
    @Override
    public long timeout() {
        return this.timeout;
    }

    /**
     * 设置监听
     *
     * @param listener 监听
     * @return this
     */
    @Override
    public Cache<K, V> setListener(CacheListener<K, V> listener) {
        this.listener = listener;
        return this;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        CacheObjIterator<K, V> copiedIterator = (CacheObjIterator<K, V>) this.cacheObjIterator();
        return new CacheValuesIterator<>(copiedIterator);
    }

    @Override
    public Iterator<CacheObject<K, V>> cacheObjIterator() {
        return new CacheObjIterator<>(this.cacheMap.values().iterator());
    }
}
