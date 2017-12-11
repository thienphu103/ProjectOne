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
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter;

/**
 * Created by ASUS on 12/11/2017.
 */

public class Adapter_Khohang extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;

    public Adapter_Khohang(Context context, ArrayList<visit_1_getter_setter> arrayList) {
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_khohang, null);
            viewHolder = new ViewHolder();
            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
    public class ViewHolder{

    }
}
