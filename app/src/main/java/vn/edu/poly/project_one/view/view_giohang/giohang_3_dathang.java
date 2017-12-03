package vn.edu.poly.project_one.view.view_giohang;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vn.edu.poly.project_one.Adapter.Adapter_3_dathang_giohang;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_3_dathang extends Fragment {
    View view_dathang;
    ListView listView;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_3_dathang_giohang adapter;
    Button btn_continue;
    public static final String URL_CALL_API_UP_DATA = "http://namtnps06077.hol.es/post_don_hang.php";
    private SharedPreferences sharedPreferences;
    int dongia_post;
    String id_post_txt;
    int soluong_post;
    String diachi_post;
    String email_post;
    String ten_post;
    String dongia_post_txt;
    String name_post_txt;
    String thanhtoan_post;
    String sdt_post;
    TextView txt_ten_giohang3;
    TextView txt_diachi_giohang3;
    TextView txt_sdt_giohang3;
    TextView txt_soluong_giohang3;
    TextView txt_tamtinh_giohang3;
    TextView txt_thanhtien_final_giohang3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_dathang = inflater.inflate(R.layout.fragment_3_dathang_giohang, container, false);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        return view_dathang;
    }

    private void initOnClick() {
    }

    private void initDisplay() {
    }

    private void initEvent() {
        sharedPreferences = getContext().getSharedPreferences("post_details_bull", MODE_PRIVATE);
        dongia_post = sharedPreferences.getInt("dongia", 0);
        id_post_txt = sharedPreferences.getString("id_sp_txt", null);
        soluong_post = sharedPreferences.getInt("soluong_sp", 0);
        diachi_post = sharedPreferences.getString("diachi", null);
        email_post = sharedPreferences.getString("email", null);
        sdt_post = sharedPreferences.getString("sdt", null);
        ten_post = sharedPreferences.getString("ten", null);
        dongia_post_txt = sharedPreferences.getString("dongia_txt", null);
        name_post_txt = sharedPreferences.getString("name_txt", null);
        thanhtoan_post = sharedPreferences.getString("thanhtoan", null);


        txt_ten_giohang3.setText(ten_post);
        txt_diachi_giohang3.setText(diachi_post);
        txt_sdt_giohang3.setText(sdt_post);
        txt_soluong_giohang3.setText("Đơn hàng("+ soluong_post+ "sản phẩm)");
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(dongia_post);
        txt_tamtinh_giohang3.setText(format+ "VND");
        int thanhtien_final=dongia_post-2000;
        String format_final = decimalFormat.format(thanhtien_final);
        txt_thanhtien_final_giohang3.setText(format_final+"");

        for (int i = 0; i < soluong_post; i++) {
            arrayList = new ArrayList<>();
            arrayList.add(new visit_1_getter_setter(name_post_txt,
                    dongia_post_txt,
                    "1x", "tên cửa hàng"));
            adapter = new Adapter_3_dathang_giohang(getActivity(), arrayList);
            listView.setAdapter(adapter);
        }

//
//        arrayList.add(new visit_1_getter_setter("Tên sản phẩm",
//                "360.000 vnd",
//                "1x", "tên cửa hàng"));

        setListViewHeightBasedOnChildren(listView);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upData();
                giohang_4_final giohang_4_final = new giohang_4_final();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_3_dathang, giohang_4_final);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    private void initControl() {
        btn_continue = (Button) view_dathang.findViewById(R.id.btn_muahang_thanhtoan_giohang);
        listView = (ListView) view_dathang.findViewById(R.id.lst_3_dathang_giohang);
        txt_ten_giohang3 = (TextView) view_dathang.findViewById(R.id.txt_ten_giohang3);
        txt_diachi_giohang3 = (TextView) view_dathang.findViewById(R.id.txt_diachi_giohang3);
        txt_sdt_giohang3 = (TextView) view_dathang.findViewById(R.id.txt_sdt_giohang3);
        txt_soluong_giohang3 = (TextView) view_dathang.findViewById(R.id.txt_soluong_giohang3);
        txt_tamtinh_giohang3 = (TextView) view_dathang.findViewById(R.id.txt_tamtinh_giohang3);
        txt_thanhtien_final_giohang3 = (TextView) view_dathang.findViewById(R.id.txt_thanhtien_final_giohang3);

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        Adapter_3_dathang_giohang listAdapter = (Adapter_3_dathang_giohang) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            if (listItem instanceof ViewGroup) {
                listItem.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }

            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public void upData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_UP_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), "" + response.toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "Đon hàng đã xác nhận (post_db)" + response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringMap = new HashMap<>();

//                    stringMap.put("image_name", IdUser);
//                    stringMap.put("image_fiel", s);
                stringMap.put("ho_ten_kh_dh", ten_post);
                stringMap.put("email_dh", email_post);
                stringMap.put("dia_chi_dh", diachi_post);
                stringMap.put("so_luong_sp", soluong_post + "");
                stringMap.put("id_sp", id_post_txt);
                stringMap.put("giao_hang_dh", "giao hàng tiêu chuẩn");
                stringMap.put("thanh_toan_dh", thanhtoan_post);
                stringMap.put("tinh_trang_dh", "Thành Công");
                return stringMap;
            }

        };
        requestQueue.add(stringRequest);
    }
}
