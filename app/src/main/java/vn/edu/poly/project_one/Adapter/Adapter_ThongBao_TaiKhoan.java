package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

/**
 * Created by ASUS on 12/19/2017.
 */

public class Adapter_ThongBao_TaiKhoan extends BaseAdapter {
    ArrayList<visit_1_getter_setter> arrayList;
    LayoutInflater inflater;
    Context context;

    public Adapter_ThongBao_TaiKhoan(ArrayList<visit_1_getter_setter> arrayList, Context context) {
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
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.listview_thongbao,null);
            viewHolder.txt_date = (TextView) convertView.findViewById(R.id.txt_date_thongbao);
            viewHolder.txt_thongbao = (TextView) convertView.findViewById(R.id.txt_thongbao);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_date.setText(arrayList.get(position).getDate_thongbao());
        viewHolder.txt_thongbao.setText(arrayList.get(position).getText_thongbao());
        return convertView;
    }
    public class ViewHolder{
        TextView txt_date, txt_thongbao;
    }
}
