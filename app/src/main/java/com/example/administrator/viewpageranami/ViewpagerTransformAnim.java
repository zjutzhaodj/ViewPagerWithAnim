package com.example.administrator.viewpageranami;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * 需要拿到当前切换的两个View
 * 需要一个动画的梯度值
 * Created by Zhaodj on 2015/12/10.
 */
public class ViewpagerTransformAnim extends ViewPager{
    private View mLeft;
    private View mRight;

    private float mTrans;
    private float mScale;

    private static final float MIN_SCALE=0.5f;

    private Map<Integer,View> mViews=new HashMap<Integer,View>();



    public ViewpagerTransformAnim(Context context) {
        this(context, null);
    }

    public ViewpagerTransformAnim(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addView(Integer integer,View view){
        mViews.put(integer, view);

    }

    public void removeViewss(Integer integer){
        mViews.remove(integer);
    }
    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        View left=mViews.get(position);
        View Right=mViews.get(position + 1);

        if(Right!=null){
            Right.setScaleY(offset);
            Right.setScaleX(offset);
            Right.setAlpha(offset);
        }

        if(left!=null){
            left.bringToFront();
        }
        Log.d("tag","position is: "+position);
        Log.d("tag","offset is: "+offset);
        Log.d("tag","offsetPixels is: "+offsetPixels);

        super.onPageScrolled(position, offset, offsetPixels);
    }

}
