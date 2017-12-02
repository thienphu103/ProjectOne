package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/2/2017.
 */

public class Adapter_gridview_nhanxetvadanhgia_details extends BaseAdapter {

    ArrayList<visit_1_getter_setter> arrayList;
    Context mContext;
    LayoutInflater inflater;

    public Adapter_gridview_nhanxetvadanhgia_details(ArrayList<visit_1_getter_setter> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        convertView = inflater.inflate(R.layout.custom_gridview_details,null);


        return convertView;
    }
}
