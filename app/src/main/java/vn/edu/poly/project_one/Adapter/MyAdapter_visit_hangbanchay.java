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
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter;

/**
 * Created by ASUS on 11/21/2017.
 */

public class MyAdapter_visit_hangbanchay extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_hangbanchay_getter_setter> arrayList;

    public MyAdapter_visit_hangbanchay(Context context, ArrayList<visit_hangbanchay_getter_setter> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public MyAdapter_visit_hangbanchay() {
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
        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_gridview_visit_hangbanchay_tablayoutactivity,null);
            viewHolder = new ViewHolder();
            viewHolder.txt_title = (TextView) convertView.findViewById(R.id.txt_title_gridview_visit_hangbanchay_tablayoutactivity);
            viewHolder.txt_price = (TextView) convertView.findViewById(R.id.txt_price_gridview_visit_hangbanchay_tablayoutactivity);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img_gridview_visit_hangbanchay_tablayoutactivity);
            convertView.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
            viewHolder.txt_title.setText(arrayList.get(position).getTitle());
            viewHolder.txt_price.setText(arrayList.get(position).getPrice());
            viewHolder.img.setImageResource(arrayList.get(position).getImg());
        return convertView;
    }

    private class ViewHolder{
        TextView txt_title,txt_price;
        ImageView img;
    }
    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
