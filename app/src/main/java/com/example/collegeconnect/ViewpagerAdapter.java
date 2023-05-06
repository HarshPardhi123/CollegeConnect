package com.example.collegeconnect;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewpagerAdapter extends PagerAdapter {
    Context context;
    int images[]={
            R.drawable.ong1,
            R.drawable.on2,
            R.drawable.ong3
    };

    int heading[]={
            R.string.headinone,
            R.string.headingtwo,
            R.string.headinfour
    };

    int description[]={
            R.string.onb1,
            R.string.onb2,
            R.string.onb3,
    };

    public ViewpagerAdapter(Context context){
        this.context=context;

    }
    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slides_layout,container,false);

        ImageView img=(ImageView) view.findViewById(R.id.imageView3);
        TextView heading1=(TextView)view.findViewById(R.id.textView);
        TextView desc=(TextView) view.findViewById(R.id.textView2);

        img.setImageResource(images[position]);
        heading1.setText(heading[position]);
        desc.setText(description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
      container.removeView((LinearLayout)object);
    }
}
