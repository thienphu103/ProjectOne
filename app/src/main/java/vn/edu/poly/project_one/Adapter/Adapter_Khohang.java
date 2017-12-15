package vn.edu.poly.project_one.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/11/2017.
 */

public class Adapter_Khohang extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<visit_1_getter_setter> arrayList;
    View.OnClickListener click,click2;

    public Adapter_Khohang(Context context, ArrayList<visit_1_getter_setter> arrayList, View.OnClickListener click,
    View.OnClickListener click2) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.click = click;
        this.click2 = click2;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_khohang, null);
            viewHolder = new ViewHolder();
            viewHolder.txt_title = (TextView) convertView.findViewById(R.id.txt_sanpham_khohang);
            viewHolder.txt_soluong = (TextView) convertView.findViewById(R.id.txt_so_luong_con_lai_khohang);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_sanpham_khohang);
            viewHolder.nhaphang = (Button) convertView.findViewById(R.id.btn_nhaphang_khohang);
            viewHolder.chinhsua = (Button) convertView.findViewById(R.id.btn_chinhsua_khohang);
            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txt_title.setText(arrayList.get(position).getTen_sp());
        viewHolder.txt_soluong.setText(arrayList.get(position).getSoluongconlai_sp());
        String url = "";
        if (!(arrayList.get(position).getHinhanh_sp().isEmpty())) {
            url = "http://namtnps06077.hol.es/" + arrayList.get(position).getHinhanh_sp();
        } else {
            url = String.valueOf(R.drawable.ic_priority_high_black_24dp);//null
        }
        Picasso.with(context)
                .load(url)
                .error(R.drawable.ic_priority_high_black_24dp)//load url error
                .placeholder(R.drawable.ic_priority_high_black_24dp)//load url error
                .resize(89, 89)
                .into(viewHolder.imageView);

        viewHolder.nhaphang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click2.onClick(view);
            }
        });



        SharedPreferences sharedPreferences_index = context.getSharedPreferences("get_index_list_view_kho_hang", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences_index.edit();
        viewHolder.chinhsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("index_listview",position);
                editor.putInt("id_sp",arrayList.get(position).getId_sp());
                editor.putString("ten_sp",arrayList.get(position).getTen_sp());
                editor.putString("check_click","dsadsadsadsadsadasasa");
                editor.commit();
//                int aa = arrayList.get(position).getId_sp();
//                Toast.makeText(context, aa+ "", Toast.LENGTH_SHORT).show();
                click.onClick(view);
            }
        });

        return convertView;
    }

    public class ViewHolder {
        TextView txt_title, txt_soluong;
        ImageView imageView;
        Button nhaphang, chinhsua;


    }
}
