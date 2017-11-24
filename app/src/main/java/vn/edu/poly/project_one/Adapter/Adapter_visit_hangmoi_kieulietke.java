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

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter_kieulietke;
import vn.edu.poly.project_one.View_getter_setter.visit_hangmoi_getter_setter_kieulietke;

/**
 * Created by ASUS on 11/23/2017.
 */

public class Adapter_visit_hangmoi_kieulietke extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_hangmoi_getter_setter_kieulietke> arrayList;


    public Adapter_visit_hangmoi_kieulietke(Context context, ArrayList<visit_hangmoi_getter_setter_kieulietke> arrayList) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1 = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_gridview_visit_hangmoi_kieulietke, null);
            viewHolder1 = new ViewHolder1();
            viewHolder1.getTxt_custom1_kieulietke = (TextView) convertView.findViewById(R.id.txt_tenhang_hangmoi_kieulietke_tablayoutactivity);
            viewHolder1.getTxt_custom2_kieulietke = (TextView) convertView.findViewById(R.id.txt_gia_hangmoi_kieulietke_tablayoutactivity);
            viewHolder1.getTxt_custom3_kieulietke = (TextView) convertView.findViewById(R.id.txt_tenhang_gia_2_kieulietke_hangmoi_tablayoutactivity);
            viewHolder1.img_kieulietke = (ImageView) convertView.findViewById(R.id.img_gridview_visit_kieulietke_hangmoi_tablayoutactivity);
            convertView.setTag(viewHolder1);
        } else {
            viewHolder1 = (ViewHolder1) convertView.getTag();
        }
        viewHolder1.getTxt_custom1_kieulietke.setText(arrayList.get(position).getTxt_custom1());
        viewHolder1.getTxt_custom2_kieulietke.setText(arrayList.get(position).getTxt_custom2());
        viewHolder1.getTxt_custom3_kieulietke.setText(arrayList.get(position).getTxt_custom3());
        viewHolder1.img_kieulietke.setImageResource(arrayList.get(position).getImg_kieulietke());

        return convertView;
    }
    public class ViewHolder1 {
        TextView getTxt_custom1_kieulietke, getTxt_custom2_kieulietke, getTxt_custom3_kieulietke;
        ImageView img_kieulietke;
    }
    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
