package systembatarka.com.batarka.app.batarkasystem.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import systembatarka.com.batarka.app.batarkasystem.Data.M5dumDataShow;
import systembatarka.com.batarka.app.batarkasystem.R;

/**
 * Created by MorcosS on 8/3/16.
 */
public class TafaselM5dumAdapter extends BaseAdapter {
    ArrayList<M5dumDataShow> list;
    LayoutInflater inflater;
    Activity activity;

    public TafaselM5dumAdapter(ArrayList<M5dumDataShow> list, Activity activity) {
        inflater = activity.getLayoutInflater();
        this.list = list;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.m5dum_details_listview,null);
        ImageButton image1 = (ImageButton) view.findViewById(R.id.imageView2);
        ImageView image2 = (ImageView) view.findViewById(R.id.imageView3);
        TextView head1 = (TextView) view.findViewById(R.id.textView3);
        TextView head2 = (TextView) view.findViewById(R.id.textView4);
        head1.setText(list.get(i).getHead1());
        head2.setText(list.get(i).getHead2());

        image1.setImageResource(view.getContext().getResources().getIdentifier(list.get(i).getImg1(), "drawable", view.getContext().getPackageName()));
        int id = view.getContext().getResources().getIdentifier(list.get(i).getImg2(), "drawable", view.getContext().getPackageName());
        image2.setImageResource(id);
        return view;
    }
}
