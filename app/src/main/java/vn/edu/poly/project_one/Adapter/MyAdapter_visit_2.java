package vn.edu.poly.project_one.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 11/19/2017.
 */

public class MyAdapter_visit_2 extends RecyclerView.Adapter<MyAdapter_visit_2.ViewHolder> {
    private ArrayList<String> strings_2;

    public MyAdapter_visit_2(ArrayList<String> strings_2) {
        this.strings_2 = strings_2;
    }

    @Override
    public MyAdapter_visit_2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_visit_tablayoutactivity_2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter_visit_2.ViewHolder holder, int position) {
            holder.textView.setText(strings_2.get(position));
    }

    @Override
    public int getItemCount() {
        return strings_2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title_textview_2);
        }
    }
}
