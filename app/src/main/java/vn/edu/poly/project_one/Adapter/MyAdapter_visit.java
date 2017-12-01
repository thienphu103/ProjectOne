package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 11/19/2017.
 */

public class MyAdapter_visit extends RecyclerView.Adapter<MyAdapter_visit.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;
    private View.OnClickListener click;
    private SharedPreferences sharedPreferences;

    public MyAdapter_visit(Context context, ArrayList<visit_1_getter_setter> arrayList,View.OnClickListener click) {
        this.context = context;
        this.arrayList = arrayList;
        this.click = click;
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
        public ViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title_textview);
            price = (TextView) itemView.findViewById(R.id.txt_price_hangbanchay_thamquan);
            img_logo = (ImageView) itemView.findViewById(R.id.img_logo_hangbanchay_thamquan);
            img_title = (ImageView) itemView.findViewById(R.id.img_cardview_hangbanchay_thamquan);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    visit_1_getter_setter visit_1_getter_setter = arrayList.get(position);
                    v.setTag(visit_1_getter_setter);
                    sharedPreferences = context.getSharedPreferences("name_test", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username_test", arrayList.get(position).getTen_sp()+"");
                    Log.d("AAAAAAA", arrayList.get(position).getTen_sp());
                    editor.commit();
                    click.onClick(v);
                }
            });
        }
    }

}
