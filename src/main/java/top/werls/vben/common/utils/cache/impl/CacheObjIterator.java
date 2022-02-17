package top.werls.vben.common.utils.cache.impl;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 缓存对象迭代器
 *
 * @author leejiawei
 * @version TODO
 * @since on  2021/10/7
 */
public class CacheObjIterator<K, V> implements Iterator<CacheObject<K, V>>, Serializable {
    @Serial
    private static final long serialVersionUID = 4379569527133574152L;

    private final Iterator<CacheObject<K, V>> iterator;
    private CacheObject<K, V> nextValue;

    public CacheObjIterator(Iterator<CacheObject<K, V>> iterator) {
        this.iterator = iterator;
        nextValue();
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {

        return nextValue != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public CacheObject<K, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        final CacheObject<K, V> cachedObject = nextValue;
        nextValue();
        return cachedObject;
    }

    /**
     * 下一个值不存在时，为null
     */
    private void nextValue() {
        while (iterator.hasNext()) {
            nextValue = iterator.next();
            if (!nextValue.isExpired()) {
                return;
            }
        }
        nextValue = null;
    }
}
