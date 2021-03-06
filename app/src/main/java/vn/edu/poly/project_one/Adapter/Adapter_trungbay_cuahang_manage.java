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
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/11/2017.
 */

public class Adapter_trungbay_cuahang_manage extends RecyclerView.Adapter<Adapter_trungbay_cuahang_manage.ViewHolder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;
    View.OnClickListener click;
    private SharedPreferences sharedPreferences;

    public Adapter_trungbay_cuahang_manage(Context context, ArrayList<visit_1_getter_setter> arrayList,View.OnClickListener click) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.click = click;
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
        holder.textView.setText(arrayList.get(position).getTen_sp());

        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(Double.parseDouble(arrayList.get(position).getGia_sp()));
        holder.price.setText(format + " VND");
        String url = "";
        if (!(arrayList.get(position).getHinhanh_sp().isEmpty())) {//null
            url = "http://namtnps06077.hol.es/"+arrayList.get(position).getHinhanh_sp();
        } else {
            url = String.valueOf(R.drawable.ic_priority_high_black_24dp);//null
        }
        Picasso.with(context)
                .load(url)
                .resize(67, 67)
                .error(R.drawable.ic_priority_high_black_24dp)//load url error
                .placeholder(R.drawable.ic_priority_high_black_24dp)//load url error
                .into(holder.img_title);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView, price;
        public ImageView img_title;

        public ViewHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.title_textview);
            price = (TextView) itemView.findViewById(R.id.txt_price_trungbay_cuahang_manage);
            img_title = (ImageView) itemView.findViewById(R.id.img_cardview_trungbay_cuahang);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    visit_1_getter_setter visit_1_getter_setter = arrayList.get(position);
                    String pattern = "###,###.###";
                    DecimalFormat decimalFormat = new DecimalFormat(pattern);
                    String format = decimalFormat.format(Double.parseDouble(arrayList.get(position).getGia_sp()));
                    v.setTag(visit_1_getter_setter);
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
