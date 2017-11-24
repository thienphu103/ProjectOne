package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.find_getter_setter;

/**
 * Created by ASUS on 11/18/2017.
 */

public class FindAdapter extends BaseAdapter {
    ArrayList<find_getter_setter> mFindArrayList;
    Context context;
    LayoutInflater inflater;

    public FindAdapter(ArrayList<find_getter_setter> mFindArrayList, Context context) {
        this.mFindArrayList = mFindArrayList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mFindArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFindArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.listview_find_xuhuong_ayoutactivity, null);
            viewHolder = new ViewHolder();
            viewHolder.txt_listview_find = (TextView)
                    convertView.findViewById(R.id.txt_listview_find_xuhuong_tablayoutactivity);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_listview_find.setText(mFindArrayList.get(position).getLst_xuhuong());
        return convertView;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
    private class ViewHolder{
        TextView txt_listview_find;

    }
}
