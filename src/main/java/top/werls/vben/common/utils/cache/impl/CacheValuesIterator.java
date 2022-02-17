package top.werls.vben.common.utils.cache.impl;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 缓存值迭代器
 *
 * @author leejiawei
 * @version TODO
 * @since on  2021/10/7
 */
public class CacheValuesIterator<V> implements Iterator<V>, Serializable {
    @Serial
    private static final long serialVersionUID = 8393709772325381931L;

    private final CacheObjIterator<?, V> cacheObjIter;

    public CacheValuesIterator(CacheObjIterator<?, V> cacheObjIter) {
        this.cacheObjIter = cacheObjIter;
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
        return this.cacheObjIter.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public V next() {
        return this.cacheObjIter.next().getValue();
    }
}
