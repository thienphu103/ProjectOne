package vn.edu.poly.project_one;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class Details extends Fragment {
    private View view_details;
    TextView txt_tensanpham_detail, txt_price_details;
    ImageView img_sp_logo_details;
    Button btn_themvaogio_details;
    private String name = "";
    private String price = "";
    private String url = "";
    private String id = "";
    private int i = 0;
    private int index;
    private SharedPreferences sharedPreferences_index;
    private SharedPreferences.Editor editor_index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_details = inflater.inflate(R.layout.fragment_detail, container, false);

        initControl();
        initOnClick();
        initEvent();

        return view_details;
    }

    private void initEvent() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details", MODE_PRIVATE);
        name = sharedPreferences.getString("name_sp", null);
        url = sharedPreferences.getString("hinhanh_sp", null);
        price = sharedPreferences.getString("gia_sp", null);
        id = sharedPreferences.getString("id_sp", null);
        if (!(url.isEmpty())) {//null
        } else {
            url = String.valueOf(R.drawable.ic_priority_high_black_24dp);//null
        }
        Picasso.with(getContext())
                .load(url)
                .resize(67, 67)
                .error(R.drawable.ic_priority_high_black_24dp)//load url error
                .placeholder(R.drawable.ic_priority_high_black_24dp)//load url error
                .into(img_sp_logo_details);
        txt_tensanpham_detail.setText(name);
        txt_price_details.setText(price);
        // Lấy dữ liệu từ Adapter;
//        SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("post_details_index", MODE_PRIVATE);
//        SharedPreferences.Editor editor_index = sharedPreferences_index.edit();
//        editor_index.putInt("index",1 );
//        editor_index.commit();
        sharedPreferences_index = getContext().getSharedPreferences("post_details_index", MODE_PRIVATE);
        editor_index = sharedPreferences_index.edit();
        index = sharedPreferences_index.getInt("index", 0);

        btn_themvaogio_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                index++;
                editor_index.putInt("index",index);
                editor_index.commit();
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details_gh", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name_sp_"+index, name);
                editor.putString("gia_sp_"+index, price);
                editor.putString("id_sp_"+index, id);
                editor.putString("hinhanh_sp_"+index, url);
                Log.d("post_details",  index+"");
                editor.commit();

                Toast.makeText(getContext(), "Sản Phẩm: " + name + " Đã Vào Giỏ Hàng !", Toast.LENGTH_SHORT).show();
            }

        });


    }


    private void initOnClick() {
    }

    private void initControl() {
        txt_tensanpham_detail = (TextView) view_details.findViewById(R.id.txt_tensanpham_detail);
        txt_price_details = (TextView) view_details.findViewById(R.id.txt_price_details);
        btn_themvaogio_details = (Button) view_details.findViewById(R.id.btn_themvaogio_details);
        img_sp_logo_details = (ImageView) view_details.findViewById(R.id.img_sp_logo_details);

    }

}
