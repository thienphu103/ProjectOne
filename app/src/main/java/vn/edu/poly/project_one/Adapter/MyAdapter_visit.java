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

public class MyAdapter_visit extends RecyclerView.Adapter<MyAdapter_visit.ViewHolder> {
    private ArrayList<String> strings;

    public MyAdapter_visit(ArrayList<String> strings) {
        this.strings = strings;
    }

    @Override
    public MyAdapter_visit.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_visit_tablayoutactivity, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter_visit.ViewHolder holder, int position) {
            holder.textView.setText(strings.get(position));
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title_textview);
        }
    }
}
