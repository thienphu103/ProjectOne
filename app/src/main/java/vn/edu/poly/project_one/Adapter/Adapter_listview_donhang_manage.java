package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/15/2017.
 */

public class Adapter_listview_donhang_manage extends BaseAdapter {
    ArrayList<visit_1_getter_setter> arrayList;
    Context context;
    LayoutInflater inflater;

    public Adapter_listview_donhang_manage(Context context, ArrayList<visit_1_getter_setter> arrayList) {
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
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_donhang_manage, null);
            viewHolder.relativeLayout = (RelativeLayout) convertView.findViewById(R.id.thunghiem);
            viewHolder.relativeLayout2 = (RelativeLayout) convertView.findViewById(R.id.thunghiem2);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.thunhgiemtext);
            viewHolder.textView2 = (TextView) convertView.findViewById(R.id.txt_khach);
            viewHolder.textView3 = (TextView) convertView.findViewById(R.id.txt_sdt);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView2.setText(arrayList.get(position).getKhach());
        viewHolder.textView3.setText(arrayList.get(position).getSdt());
        viewHolder.textView.setText(arrayList.get(position).getText_donhang());
        viewHolder.relativeLayout.setBackgroundColor(arrayList.get(position).getBackground());
        viewHolder.relativeLayout2.setBackgroundColor(arrayList.get(position).getBackground_2());
        return convertView;
    }

    public class ViewHolder {
        RelativeLayout relativeLayout, relativeLayout2;
        TextView textView, textView2, textView3;
    }
}
