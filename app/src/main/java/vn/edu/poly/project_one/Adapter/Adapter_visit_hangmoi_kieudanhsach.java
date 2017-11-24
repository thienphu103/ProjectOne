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
import vn.edu.poly.project_one.View_getter_setter.visit_hangmoi_getter_setter_kieudanhsach;

/**
 * Created by ASUS on 11/23/2017.
 */

public class Adapter_visit_hangmoi_kieudanhsach extends BaseAdapter{
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_hangmoi_getter_setter_kieudanhsach> arrayList;

    public Adapter_visit_hangmoi_kieudanhsach(Context context, ArrayList<visit_hangmoi_getter_setter_kieudanhsach> arrayList) {
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
        {
            ViewHolder viewHolder = null;
            if(convertView == null){
                convertView = inflater.inflate(R.layout.custom_girdview_visit_hangmoi_kieudanhsach,null);
                viewHolder = new ViewHolder();
                viewHolder.txt_title = (TextView) convertView.findViewById(R.id.txt_title_gridview_visit_hangmoi_tablayoutactivity);
                viewHolder.txt_price = (TextView) convertView.findViewById(R.id.txt_price_gridview_visit_hangmoi_tablayoutactivity);
                viewHolder.img = (ImageView) convertView.findViewById(R.id.img_gridview_visit_hangmoi_tablayoutactivity);
                convertView.setTag(viewHolder);


            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.txt_title.setText(arrayList.get(position).getTitle());
            viewHolder.txt_price.setText(arrayList.get(position).getPrice());
            viewHolder.img.setImageResource(arrayList.get(position).getImg());
            return convertView;
        }

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
