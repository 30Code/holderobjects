package cn.linhome.holderobjects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import cn.linhome.lib.holder.objects.FObjectsHolder;
import cn.linhome.lib.holder.objects.FStrongObjectsHolder;
import cn.linhome.lib.holder.objects.ForeachCallback;

public class MainActivity extends AppCompatActivity
{
    public static final String TAG = MainActivity.class.getSimpleName();

    private FObjectsHolder<View> mHolder = new FStrongObjectsHolder<>();
//    private FObjectsHolder<View> mHolder = new FWeakObjectsHolder<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doForeach(true);
                doForeachReverse(true);
            }
        });

        fillData();
    }

    private void fillData()
    {
        mHolder.clear(); //清空所有对象
        for (int i = 0; i < 10; i++)
        {
            View view = new View(this);
            view.setTag(i);

            mHolder.add(view); //添加对象
        }
    }

    private void doForeach(final boolean log)
    {
        /**
         * 正序遍历
         */
        mHolder.foreach(new ForeachCallback<View>()
        {
            @Override
            protected void next(View item)
            {
                if (log)
                {
                    Log.i(TAG, String.valueOf(item.getTag()));
                }
            }
        });
    }

    private void doForeachReverse(final boolean log)
    {
        /**
         * 倒序遍历
         */
        mHolder.foreachReverse(new ForeachCallback<View>()
        {
            @Override
            protected void next(View item)
            {
                if (log)
                {
                    Log.e(TAG, String.valueOf(item.getTag()));
                }
            }
        });
    }
}
