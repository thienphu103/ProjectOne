package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter_kieulietke;

/**
 * Created by ASUS on 11/22/2017.
 */

public class Adapter_visit_hangbanchay_kieulietke extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_hangbanchay_getter_setter_kieulietke> arrayList;

    public Adapter_visit_hangbanchay_kieulietke(Context context, ArrayList<visit_hangbanchay_getter_setter_kieulietke> arrayList) {
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
        TextView getTxt_custom1, getTxt_custom2, getTxt_custom3;
        ImageView img_kieulietke;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_gridview_kieulietke_hangbanchay_tablayoutactivity, null);
            viewHolder = new ViewHolder();
            viewHolder.getTxt_custom1 = (TextView) convertView.findViewById(R.id.txt_tenhang_hangbanchay_kieulietke_tablayoutactivity);
            viewHolder.getTxt_custom2 = (TextView) convertView.findViewById(R.id.txt_gia_hangbanchay_kieulietke_tablayoutactivity);
            viewHolder.getTxt_custom3 = (TextView) convertView.findViewById(R.id.txt_tenhang_gia_2_kieulietke_tablayoutactivity);
            viewHolder.img_kieulietke = (ImageView) convertView.findViewById(R.id.img_gridview_visit_kieulietke_hangbanchay_tablayoutactivity);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.getTxt_custom1.setText(arrayList.get(position).getTxt_custom1());
        viewHolder.getTxt_custom2.setText(arrayList.get(position).getTxt_custom2());
        viewHolder.getTxt_custom3.setText(arrayList.get(position).getTxt_custom3());
        viewHolder.img_kieulietke.setImageResource(arrayList.get(position).getImg_kieulietke());
        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
