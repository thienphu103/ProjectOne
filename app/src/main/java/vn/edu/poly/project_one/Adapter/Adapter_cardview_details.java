package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/2/2017.
 */

public class Adapter_cardview_details extends RecyclerView.Adapter<Adapter_cardview_details.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;
    public Adapter_cardview_details(Context context, ArrayList<visit_1_getter_setter> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public Adapter_cardview_details.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_details, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Adapter_cardview_details.ViewHolder holder, int position) {
        holder.img_sanpham.setImageResource(Integer.parseInt(arrayList.get(position).getHinhanh_sp()));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_sanpham;
        public ViewHolder(View itemView) {
            super(itemView);
            img_sanpham = (ImageView) itemView.findViewById(R.id.img_sanpham_cardview_details);
        }
    }
}
