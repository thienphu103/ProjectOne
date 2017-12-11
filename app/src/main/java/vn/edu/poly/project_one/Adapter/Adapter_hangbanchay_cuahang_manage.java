package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/11/2017.
 */

public class Adapter_hangbanchay_cuahang_manage extends RecyclerView.Adapter<Adapter_hangbanchay_cuahang_manage.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;
    public Adapter_hangbanchay_cuahang_manage(Context context, ArrayList<visit_1_getter_setter> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_hangbanchay_cuahang_manage, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
