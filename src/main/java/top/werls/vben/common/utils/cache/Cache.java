package top.werls.vben.common.utils.cache;



import top.werls.vben.common.utils.cache.impl.CacheObject;

import java.io.Serializable;
import java.util.Iterator;

/**
 * key/value 缓存 接口
 *
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/29
 */
public interface Cache<K, V> extends Iterable<V>, Serializable {

    /**
     * 将对象添加到缓冲中，默认超时时间
     *
     * @param key    键值
     * @param object 缓冲对象
     */
    void put(K key, V object);

    /**
     * 将对象添加到缓冲中，设置超时时间
     *
     * @param key     键
     * @param object  值
     * @param timeout 超时
     */
    void put(K key, V object, long timeout);

    /**
     * 获取值
     *
     * @param key 键
     * @return 返回值 V
     */
    V get(K key);


    /**
     * 移除对象
     *
     * @param key 键
     */
    void remove(K key);

    /**
     * 缓冲大小
     *
     * @return 缓冲的中大小
     */
    int size();

    /**
     * 返回缓存是否满
     *
     * @return 缓存是否满
     */
    boolean isFull();

    /**
     * 缓存是否空
     *
     * @return 缓存是否为空
     */
    boolean isEmpty();

    /**
     * 是否包含key
     *
     * @param key KEY
     * @return 是否包含key
     */
    boolean containsKey(K key);

    /**
     * 返回缓存容量，{@code 0}表示无大小限制
     *
     * @return 返回缓存容量，{@code 0}表示无大小限制
     */
    int capacity();

    /**
     * 清除缓存
     */
    void clear();


    /**
     * 缓存失效时长， {@code 0} 表示没有设置，单位毫秒
     *
     * @return 缓存失效时长， {@code 0} 表示没有设置，单位毫秒
     */
    long timeout();

    /**
     * 设置监听
     *
     * @param listener 监听
     * @return this
     */
    default Cache<K, V> setListener(CacheListener<K, V> listener) {
        return this;
    }

    Iterator<CacheObject<K, V>> cacheObjIterator();

    interface CacheListener<K, V> {

        /**
         * 对象移除回调
         *
         * @param key          键
         * @param cachedObject 被缓存的对象
         */
        void onRemove(K key, V cachedObject);
    }

}
