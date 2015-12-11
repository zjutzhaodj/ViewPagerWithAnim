package com.example.administrator.viewpageranami;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private ViewpagerTransformAnim mviewPager;
    private int[] mImgids = new int[]{R.drawable.a, R.drawable.b, R.drawable.c};
    private List<ImageView> mImages = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mviewPager = (ViewpagerTransformAnim) findViewById(R.id.viewpager);
        mviewPager.setAdapter(new PagerAdapter() {

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(mImgids[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                mImages.add(imageView);
                mviewPager.addView(position, imageView);
                return imageView;

            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImages.get(position));
                mviewPager.removeViewss(position);

            }

            @Override
            public int getCount() {
                return mImgids.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }
        });
    }


}
