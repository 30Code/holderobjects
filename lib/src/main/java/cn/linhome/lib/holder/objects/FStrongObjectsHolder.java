package cn.linhome.lib.holder.objects;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 强引用对象holder
 *
 * @param <T>
 */
public class FStrongObjectsHolder<T> extends FAbstractObjectsHolder<T>
{
    private final List<T> mListObject = new CopyOnWriteArrayList<>();

    @Override
    public boolean add(T object)
    {
        if (object == null || contains(object))
        {
            return false;
        }

        mListObject.add(object);
        return true;
    }

    @Override
    public boolean remove(Object object)
    {
        return mListObject.remove(object);
    }

    @Override
    public boolean contains(T object)
    {
        return mListObject.contains(object);
    }

    @Override
    public int size()
    {
        return mListObject.size();
    }

    @Override
    public void clear()
    {
        mListObject.clear();
    }

    @Override
    public Object foreach(ForeachCallback<T> callback)
    {
        if (callback == null)
        {
            return null;
        }

        for (T item : mListObject)
        {
            callback.next(item);
            if (callback.isBreakForeach())
            {
                break;
            }
        }
        return callback.getData();
    }

    @Override
    public Object foreachReverse(ForeachCallback<T> callback)
    {
        if (callback == null)
        {
            return null;
        }

        final ListIterator<T> it = mListObject.listIterator(mListObject.size());
        while (it.hasPrevious())
        {
            callback.next(it.previous());
            if (callback.isBreakForeach())
            {
                break;
            }
        }
        return callback.getData();
    }

    @Override
    public String getObjectsString()
    {
        return mListObject.toString();
    }
}
