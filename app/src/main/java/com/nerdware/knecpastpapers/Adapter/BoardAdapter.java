package com.nerdware.knecpastpapers.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.nerdware.knecpastpapers.R;

public class BoardAdapter extends PagerAdapter {

    Context context;
    int image[] = {
            R.drawable.board,
            R.drawable.board,
            R.drawable.board_3
    };

    int headings[] =  {
                R.string.board_title,
                R.string.board_title_2,
                R.string.board_title_3

    };

    int description[] = {
            R.string.board_body,
            R.string.desc_2,
            R.string.disc_3
    };

    public BoardAdapter(Context context){
        this.context = context;

    }
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slideImage = (ImageView) view.findViewById(R.id.img_board);
        TextView slideTitle = (TextView) view.findViewById(R.id.text_title);
        TextView slideDescription =(TextView) view.findViewById(R.id.text_body);


        slideImage.setImageResource(image[position]);
        slideTitle.setText(headings[position]);
        slideDescription.setText(description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
