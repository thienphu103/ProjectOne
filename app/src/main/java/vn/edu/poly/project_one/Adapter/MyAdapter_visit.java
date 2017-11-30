package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 11/19/2017.
 */

public class MyAdapter_visit extends RecyclerView.Adapter<MyAdapter_visit.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;

    public MyAdapter_visit(Context context, ArrayList<visit_1_getter_setter> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            holder.textView.setText(arrayList.get(position).getTen_sp());
            holder.price.setText(arrayList.get(position).getGia_sp());
        String url="";
        if(!(arrayList.get(position).getHinhanh_sp().isEmpty())) {//null
            url=arrayList.get(position).getHinhanh_sp();
        }else{
            url= String.valueOf(R.drawable.ic_priority_high_black_24dp);//null
        }
        Picasso.with(context)
                .load(url)
                .resize(67,67)
                .error(R.drawable.ic_priority_high_black_24dp)//load url error
                .placeholder(R.drawable.ic_priority_high_black_24dp)//load url error
                .into(holder.img_title);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView,price;
        public ImageView img_title, img_logo;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title_textview);
            price = (TextView) itemView.findViewById(R.id.txt_price_hangbanchay_thamquan);
            img_logo = (ImageView) itemView.findViewById(R.id.img_logo_hangbanchay_thamquan);
            img_title = (ImageView) itemView.findViewById(R.id.img_cardview_hangbanchay_thamquan);
        }
    }
}
