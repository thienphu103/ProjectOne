package vn.edu.poly.project_one.view.View_taikhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_ThongBao_TaiKhoan;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;
import vn.edu.poly.project_one.view.Tai_Khoan;

/**
 * Created by ASUS on 12/19/2017.
 */

public class ThongBao_TaiKhoan extends Fragment {
    View view_thongbao;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_ThongBao_TaiKhoan adapter;
    ListView listView;
    private View relativeLayout2;
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/send_notification_to_customer.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_thongbao = inflater.inflate(R.layout.fragment_thongbao, container, false);
        initControl();
        initEvent();
        return view_thongbao;
    }

    private void initEvent() {
//        arrayList = new ArrayList<>();
//        arrayList.add(new visit_1_getter_setter("THỨ TƯ, 20 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
//        arrayList.add(new visit_1_getter_setter("THỨ NĂM, 21 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
//        arrayList.add(new visit_1_getter_setter("THỨ SÁU, 22 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
//        arrayList.add(new visit_1_getter_setter("THỨ BẢY, 23 THÁNG 12","Deal sốc LNL đến 50%. Mua sắm thả ga, nhận ngay quà chất từ lock: tặng vé Mama Music 2017 và nhiều quà tặng khác"));
//        adapter = new Adapter_ThongBao_TaiKhoan(arrayList,getContext());
//        listView.setAdapter(adapter);
        getData();
        relativeLayout2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Tai_Khoan DonHangcuaToi_TaiKhoan = new Tai_Khoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_thongbao, DonHangcuaToi_TaiKhoan, "sometag");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                return false;
            }
        });
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URL_CALL_API_GET_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String content;
                String date;
                arrayList = new ArrayList();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);

                        content = object.getString("contents_noti");
                        date = object.getString("time_noti");
                        String day1 = date.substring(0, date.indexOf(","));
                        String day = date.substring(date.indexOf(","), date.length());

                        String mouth = day.replace("-", " Tháng ");

//                        Log.d("date_notification", date + "");

                        arrayList.add(new visit_1_getter_setter(convertDay(day1) + " " + mouth, content));

                        if (getContext() != null) {
                            adapter = new Adapter_ThongBao_TaiKhoan(arrayList, getContext());
                            adapter.notifyDataSetChanged();
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    listView.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(arrayRequest);
    }

    private void initControl() {
        listView = (ListView) view_thongbao.findViewById(R.id.lst_thongbao);
        relativeLayout2 = (RelativeLayout) view_thongbao.findViewById(R.id.layout_back_thongbao);
    }

    private String convertDay(String day) {
        if (day.toString().trim().equals("Monday")) {
            return "Thứ Hai";
        }
        if (day.equals("Tuesday")) {
            return "Thứ Ba";
        }
        if (day.equals("Wednesday")) {
            return "Thứ Tư";
        }
        if (day.equals("Thursday")) {
            return "Thứ Năm";
        }
        if (day.equals("Friday")) {
            return "Thứ Sáu";
        }
        if (day.equals("Saturday")) {
            return "Thứ Bảy";
        }
        if (day.equals("Sunday")) {
            return "Chủ Nhật";
        }
        return null;
    }
}
