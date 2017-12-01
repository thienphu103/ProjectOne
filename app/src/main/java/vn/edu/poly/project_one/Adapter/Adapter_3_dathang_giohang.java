package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/1/2017.
 */

public class Adapter_3_dathang_giohang extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;

    public Adapter_3_dathang_giohang(Context context, ArrayList<visit_1_getter_setter> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txt_soluong,txt_tensanpham,txt_price,txt_tencuahang;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.listview_3_dathang_giohang, null);
            viewHolder = new ViewHolder();
            viewHolder.txt_soluong = (TextView)
                    convertView.findViewById(R.id.x1);
            viewHolder.txt_tensanpham = (TextView)
                    convertView.findViewById(R.id.txt_tensanpham_dathang_giohang);
            viewHolder.txt_price = (TextView)
                    convertView.findViewById(R.id.txt_price_dathang_giohang);
            viewHolder.txt_tencuahang = (TextView)
                    convertView.findViewById(R.id.txt_tencuahang_giohang);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_tensanpham.setText(arrayList.get(position).getTen_sp());
        viewHolder.txt_price.setText(arrayList.get(position).getGia_sp());
        viewHolder.txt_soluong.setText(arrayList.get(position).getSoluong());
        viewHolder.txt_tencuahang.setText(arrayList.get(position).getName_cuahang());
        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
