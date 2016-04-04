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

public class CustomTurismoActivity extends PagerAdapter {
    private int[] image_resources = {R.drawable.catedral, R.drawable.ronda, R.drawable.mirador};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomTurismoActivity(Context ctx){
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
        View item_view = layoutInflater.inflate(R.layout.turismo, container, false);
        ImageView imageView= (ImageView) item_view.findViewById(R.id.image_view);
        TextView tCatedral= (TextView) item_view.findViewById(R.id.tCatedral);
        TextView tRonda= (TextView) item_view.findViewById(R.id.tRonda);
        TextView tMir= (TextView) item_view.findViewById(R.id.tMirador);
        TextView tinfCatedral= (TextView) item_view.findViewById(R.id.tinfCatedral);
        TextView tinfRonda= (TextView) item_view.findViewById(R.id.tinfRonda);
        TextView tinfMir= (TextView) item_view.findViewById(R.id.tinfMirador);
        imageView.setImageResource(image_resources[position]);
        switch (position){
            case 0:
                tCatedral.setVisibility(View.VISIBLE);
                tRonda.setVisibility(View.GONE);
                tMir.setVisibility(View.GONE);
                tinfCatedral.setVisibility(View.VISIBLE);
                tinfRonda.setVisibility(View.GONE);
                tinfMir.setVisibility(View.GONE);
                break;
            case 1:
                tinfCatedral.setVisibility(View.GONE);
                tinfRonda.setVisibility(View.VISIBLE);
                tinfMir.setVisibility(View.GONE);
                tCatedral.setVisibility(View.GONE);
                tRonda.setVisibility(View.VISIBLE);
                tMir.setVisibility(View.GONE);
                break;
            case 2:
                tCatedral.setVisibility(View.GONE);
                tRonda.setVisibility(View.GONE);
                tMir.setVisibility(View.VISIBLE);
                tinfCatedral.setVisibility(View.GONE);
                tinfRonda.setVisibility(View.GONE);
                tinfMir.setVisibility(View.VISIBLE);
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
