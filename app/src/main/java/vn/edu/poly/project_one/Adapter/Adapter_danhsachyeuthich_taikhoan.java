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
import vn.edu.poly.project_one.View_getter_setter.taikhoan_danhsachyeuthich_getter_setter;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter_kieulietke;

/**
 * Created by ASUS on 11/22/2017.
 */

public class Adapter_danhsachyeuthich_taikhoan extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<taikhoan_danhsachyeuthich_getter_setter> arrayList;

    public Adapter_danhsachyeuthich_taikhoan(Context context, ArrayList<taikhoan_danhsachyeuthich_getter_setter> arrayList) {
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
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_gridview_danhsachyeuthich_taikhoan, null);
            viewHolder = new ViewHolder();
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img_gridview_danhsachyeuthich_taikhoan);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.img.setImageResource(arrayList.get(position).getImages());
        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
