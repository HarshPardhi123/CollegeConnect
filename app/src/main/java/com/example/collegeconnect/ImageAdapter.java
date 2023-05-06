package com.example.collegeconnect;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mcontext;

    int[] images={
            R.drawable.gallery1,
            R.drawable.gallery2,
            R.drawable.gallery3,
            R.drawable.gallery4,
            R.drawable.gallery5,
            R.drawable.sarvadesir,
            R.drawable.gallery1,
            R.drawable.gallery2,
            R.drawable.gallery3,
            R.drawable.gallery4,
            R.drawable.gallery5,
            R.drawable.sarvadesir

    };

    public ImageAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView=new ImageView(mcontext);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(340,350));

        return imageView;
    }
}
