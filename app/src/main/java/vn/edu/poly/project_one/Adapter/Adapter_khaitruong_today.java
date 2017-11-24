package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.today_khaitruong_setter_getter;

/**
 * Created by ASUS on 11/23/2017.
 */

public class Adapter_khaitruong_today extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<today_khaitruong_setter_getter> arrayList;

    public Adapter_khaitruong_today(Context context, ArrayList<today_khaitruong_setter_getter> arrayList) {
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
    public class ViewHoder{
        TextView custom1,custom2,custom3;
        ImageView img;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_today_khaitruong, null);
            viewHolder = new  ViewHoder();
            viewHolder.custom1 = (TextView) convertView.findViewById(R.id.txt_custom1_today_khaitruong_tablayoutactivity);
            viewHolder.custom2 = (TextView) convertView.findViewById(R.id.txt_custom2_today_khaitruong_tablayoutactivity);
            viewHolder.custom3 = (TextView) convertView.findViewById(R.id.btn_custom3_today_khaitruong_tablayoutactivity);
            viewHolder.img= (ImageView) convertView.findViewById(R.id.avatar_anh_beyeu);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHoder) convertView.getTag();
        }
        viewHolder.custom1.setText(arrayList.get(position).getCustom1());
        viewHolder.custom2.setText(arrayList.get(position).getCustom2());
        viewHolder.custom3.setText(arrayList.get(position).getCustom3());
        viewHolder.img.setImageResource(arrayList.get(position).getImg_logo());
        return convertView;
    }
}
