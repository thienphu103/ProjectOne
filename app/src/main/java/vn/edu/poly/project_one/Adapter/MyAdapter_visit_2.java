package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_2_getter_setter;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 11/19/2017.
 */

public class MyAdapter_visit_2 extends RecyclerView.Adapter<MyAdapter_visit_2.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_2_getter_setter> arrayList;
    private SharedPreferences sharedPreferences;
    private View.OnClickListener click;

    public MyAdapter_visit_2(Context context, ArrayList<visit_2_getter_setter> arrayList,View.OnClickListener click) {
        this.context = context;
        this.arrayList = arrayList;
        this.click = click;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            holder.textView.setText(arrayList.get(position).getTen_sp());
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(Double.parseDouble(arrayList.get(position).getGia_sp()));
        holder.price.setText(format+" VND");
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
            textView = (TextView) itemView.findViewById(R.id.title_textview_2);
            price = (TextView) itemView.findViewById(R.id.txt_price_hangbanchay_thamquan_2);
            img_logo = (ImageView) itemView.findViewById(R.id.img_logo_hangbanchay_thamquan_2);
            img_title = (ImageView) itemView.findViewById(R.id.img_cardview_hangbanchay_thamquan_2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    visit_2_getter_setter visit_2_getter_setter = arrayList.get(position);
                    v.setTag(visit_2_getter_setter);
                    sharedPreferences = context.getSharedPreferences("post_details", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name_sp", arrayList.get(position).getTen_sp() + "");
                    editor.putString("gia_sp", arrayList.get(position).getGia_sp()+"");
                    editor.putString("id_sp", arrayList.get(position).getId_sp() + "");
                    editor.putString("hinhanh_sp", arrayList.get(position).getHinhanh_sp() + "");
//                    editor.putString("soluong",arrayList.get(position).getSoluongconlai_sp()+"");
                    Log.d("AAAAAAA", arrayList.get(position).getTen_sp());
                    editor.commit();
                    click.onClick(v);
                }
            });
        }
    }
}
