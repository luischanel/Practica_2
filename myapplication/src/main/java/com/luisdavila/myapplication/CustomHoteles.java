package com.luisdavila.myapplication;
//No es una actividad, me confundí
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomHoteles extends PagerAdapter {
    private int[] image_resources = {R.drawable.hotelsinu, R.drawable.hotelbaroca, R.drawable.hotelflorida};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomHoteles(Context ctx){
        this.ctx=ctx;

    }
    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view==(LinearLayout)o );
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.hoteles, container, false);
        ImageView imageView= (ImageView) item_view.findViewById(R.id.image_view);
        TextView t1= (TextView) item_view.findViewById(R.id.tSinu);
        TextView t2= (TextView) item_view.findViewById(R.id.tBaroca);
        TextView t3= (TextView) item_view.findViewById(R.id.tFlorida);
        TextView tinf1= (TextView) item_view.findViewById(R.id.tinfSinu);
        TextView tinf2= (TextView) item_view.findViewById(R.id.tinfBaroca);
        TextView tinf3= (TextView) item_view.findViewById(R.id.tinfFlorida);
        imageView.setImageResource(image_resources[position]);
        switch (position){
            case 0:
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.GONE);
                t3.setVisibility(View.GONE);
                tinf1.setVisibility(View.VISIBLE);
                tinf2.setVisibility(View.GONE);
                tinf3.setVisibility(View.GONE);
                break;
            case 1:
                tinf1.setVisibility(View.GONE);
                tinf2.setVisibility(View.VISIBLE);
                tinf2.setVisibility(View.GONE);
                t1.setVisibility(View.GONE);
                t2.setVisibility(View.VISIBLE);
                t3.setVisibility(View.GONE);
                break;
            case 2:
                t1.setVisibility(View.GONE);
                t2.setVisibility(View.GONE);
                t3.setVisibility(View.VISIBLE);
                tinf1.setVisibility(View.GONE);
                tinf2.setVisibility(View.GONE);
                tinf3.setVisibility(View.VISIBLE);
                break;
        }
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
