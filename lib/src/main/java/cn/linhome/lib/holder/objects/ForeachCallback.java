package cn.linhome.lib.holder.objects;

/**
 * des:
 * Created by 30Code
 * on 2018/9/19
 */
public abstract class ForeachCallback<T>
{
    private boolean mIsBreakForeach;
    private Object mData;

    public final boolean isBreakForeach()
    {
        return mIsBreakForeach;
    }

    public final void breakForeach()
    {
        mIsBreakForeach = true;
    }

    public final void setData(Object data)
    {
        mData = data;
    }

    public final Object getData()
    {
        return mData;
    }

    protected abstract void next(T item);
}
