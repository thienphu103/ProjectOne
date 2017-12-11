package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/11/2017.
 */

public class Adapter_trungbay_cuahang_manage extends RecyclerView.Adapter<Adapter_trungbay_cuahang_manage.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;
    public Adapter_trungbay_cuahang_manage(Context context, ArrayList<visit_1_getter_setter> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public Adapter_trungbay_cuahang_manage.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_trungbay_cuahang_manage, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Adapter_trungbay_cuahang_manage.ViewHolder holder, int position) {
//        holder.textView.setText(arrayList.get(position).getTen_sp());
//        holder.price.setText(arrayList.get(position).getGia_sp());
//        holder.img_logo.setImageResource(Integer.parseInt(arrayList.get(position).getLogo_cuahang()));
//        holder.img_title.setImageResource(Integer.parseInt(arrayList.get(position).getHinhanh_sp()));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView, price;
        public ImageView img_title, img_logo;
        public ViewHolder(View itemView) {
            super(itemView);
//            textView = (TextView) itemView.findViewById(R.id.title_textview);
//            price = (TextView) itemView.findViewById(R.id.txt_price_trungbay_cuahang_manage);
//            img_logo = (ImageView) itemView.findViewById(R.id.img_logo_trungbay_cuahang_manage);
//            img_title = (ImageView) itemView.findViewById(R.id.img_cardview_trungbay_cuahang);
        }
    }
}
