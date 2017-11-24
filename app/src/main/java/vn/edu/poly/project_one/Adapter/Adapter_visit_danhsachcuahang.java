package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_danhsachcuahang_getter_setter;

/**
 * Created by ASUS on 11/21/2017.
 */

public class Adapter_visit_danhsachcuahang extends BaseAdapter {
    ArrayList<visit_danhsachcuahang_getter_setter> arrayList;
    Context context;
    LayoutInflater inflater;

    public Adapter_visit_danhsachcuahang() {
    }

    public Adapter_visit_danhsachcuahang(ArrayList<visit_danhsachcuahang_getter_setter> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.listview_visit_danhsachcuahang_tablayoutactivity,null);
            viewHolder = new ViewHolder();
            viewHolder.txt_custom1 = (TextView) convertView.findViewById(R.id.txt_custom1_danhsachcuahang_tablayoutactivity);
            viewHolder.txt_custom2 = (TextView) convertView.findViewById(R.id.txt_custom2_danhsachcuahang_tablayoutactivity);
            viewHolder.btn_custom3 = (Button) convertView.findViewById(R.id.btn_custom3_danhsachcuahang_tablayoutactivity);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_custom1.setText(arrayList.get(position).getTxt_custom1());
        viewHolder.txt_custom2.setText(arrayList.get(position).getTxt_custom2());
        viewHolder.btn_custom3.setText(arrayList.get(position).getBtn_custom3());
        return convertView;
    }
    private class ViewHolder{
        TextView txt_custom1,txt_custom2,btn_custom3;

    }
    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
