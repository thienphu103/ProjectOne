package vn.edu.poly.project_one.Adapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.fragment_sign_up.fragment_sign_up_2;

/**
 * Created by ASUS on 11/25/2017.
 */

public class Adapter_cardview_today extends RecyclerView.Adapter<Adapter_cardview_today.ViewHolder> {
    ArrayList<String> arrayList;
    public Adapter_cardview_today(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public Adapter_cardview_today.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_today, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Adapter_cardview_today.ViewHolder holder, int position) {
            holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txt_today_cardview);
        }
    }
}
