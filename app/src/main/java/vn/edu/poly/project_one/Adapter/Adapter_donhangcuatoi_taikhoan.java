package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.donhangcuatui_taikhoan_getter_setter;

/**
 * Created by ASUS on 11/27/2017.
 */

public class Adapter_donhangcuatoi_taikhoan extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<donhangcuatui_taikhoan_getter_setter> arrayList;


    public Adapter_donhangcuatoi_taikhoan(Context context, ArrayList arrayList) {
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

    public class ViewHolder {
        TextView getTxt_id, getTxt_dongia, getTxt_noidung,getTxt_date;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Adapter_donhangcuatoi_taikhoan.ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cardview_donhangcuatoi_taikhoan, null);
            viewHolder=new ViewHolder();
            viewHolder.getTxt_id = (TextView) convertView.findViewById(R.id.id_donhangcuatui_taikhoan);
            viewHolder.getTxt_dongia = (TextView) convertView.findViewById(R.id.dongia_donhangcuatui_taikhoan);
            viewHolder.getTxt_noidung = (TextView) convertView.findViewById(R.id.noidung_donhangcuatui_taikhoan);
            viewHolder.getTxt_date=(TextView) convertView.findViewById(R.id.date_donhangcuatui_taikhoan) ;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Adapter_donhangcuatoi_taikhoan.ViewHolder) convertView.getTag();
        }
        viewHolder.getTxt_id.setText("#"+arrayList.get(position).getTxt_id()+" - ");
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(Double.parseDouble(arrayList.get(position).getTxt_price()));
        viewHolder.getTxt_dongia.setText(format+" VND");
        viewHolder.getTxt_noidung.setText(arrayList.get(position).getTxt_content());
        viewHolder.getTxt_date.setText(arrayList.get(position).getTxt_date());
        return convertView;
    }
    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
