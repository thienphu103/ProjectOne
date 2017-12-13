package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.find_getter_setter;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 11/18/2017.
 */

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.ViewHolder> {
    ArrayList<find_getter_setter> mFindArrayList;
    Context context;
    LayoutInflater inflater;
    private View.OnClickListener click;
    View v;
    private SharedPreferences sharedPreferences;

    public FindAdapter(ArrayList<find_getter_setter> mFindArrayList, Context context, View.OnClickListener click) {
        this.mFindArrayList = mFindArrayList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.click = click;
    }

    @Override
    public FindAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listview_find_xuhuong_ayoutactivity, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(FindAdapter.ViewHolder holder, int position) {
        holder.txt_listview_find.setText(mFindArrayList.get(position).getLst_xuhuong());
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(Double.parseDouble(mFindArrayList.get(position).getPrice()));
        holder.txt_listview_find_price.setText(format + " VND");
        String url = "";
        if (!(mFindArrayList.get(position).getImage().isEmpty())) {//null
            url = "http://namtnps06077.hol.es/"+mFindArrayList.get(position).getImage();
        } else {
            url = String.valueOf(R.drawable.ic_priority_high_black_24dp);//null
        }
        Picasso.with(context)
                .load(url)
                .resize(89, 89)
                .error(R.drawable.ic_priority_high_black_24dp)//load url error
                .placeholder(R.drawable.ic_priority_high_black_24dp)//load url error
                .into(holder.txt_listview_find_image);


    }

    @Override
    public int getItemCount() {
        return mFindArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView txt_listview_find;
        public  TextView txt_listview_find_price;
        public  ImageView txt_listview_find_image;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_listview_find = (TextView) itemView.findViewById(R.id.txt_listview_find_xuhuong_tablayoutactivity);
            txt_listview_find_image=(ImageView) itemView.findViewById(R.id.image_find_xuhuong);
            txt_listview_find_price=(TextView) itemView.findViewById(R.id.txt_price_find_xuhuong);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    find_getter_setter find_getter_setter = mFindArrayList.get(position);
                    String pattern = "###,###.###";
                    DecimalFormat decimalFormat = new DecimalFormat(pattern);
                    String format = decimalFormat.format(Double.parseDouble(mFindArrayList.get(position).getPrice()));
                    v.setTag(find_getter_setter);
                    sharedPreferences = context.getSharedPreferences("post_details", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name_sp", mFindArrayList.get(position).getLst_xuhuong() + "");
                    editor.putString("gia_sp", mFindArrayList.get(position).getPrice()+"");
                    editor.putString("id_sp", mFindArrayList.get(position).getId() + "");
                    editor.putString("hinhanh_sp", mFindArrayList.get(position).getImage() + "");
//                    editor.putString("soluong",arrayList.get(position).getSoluongconlai_sp()+"");
                    Log.d("AAAAAAA", mFindArrayList.get(position).getLst_xuhuong());
                    editor.commit();
                    click.onClick(v);
                }
            });
        }
    }

//    @Override
//    public int getCount() {
//        return mFindArrayList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mFindArrayList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder = null;
//        if (convertView == null){
//            convertView = inflater.inflate(R.layout.listview_find_xuhuong_ayoutactivity, null);
//            viewHolder = new ViewHolder();
//            viewHolder.txt_listview_find = (TextView)
//                    convertView.findViewById(R.id.txt_listview_find_xuhuong_tablayoutactivity);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        viewHolder.txt_listview_find.setText(mFindArrayList.get(position).getLst_xuhuong());
//        return convertView;
//    }
//
//    @Nullable
//    @Override
//    public CharSequence[] getAutofillOptions() {
//        return new CharSequence[0];
//    }
//    private class ViewHolder{
//        TextView txt_listview_find;
//
//    }
}
