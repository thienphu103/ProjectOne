package vn.edu.poly.project_one.view.View_taikhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
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

import vn.edu.poly.project_one.Adapter.Adapter_donhangcuatoi_taikhoan;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.donhangcuatui_taikhoan_getter_setter;

/**
 * Created by ASUS on 11/26/2017.
 */

public class DonHangcuaToi_TaiKhoan extends Fragment {
    View view_taikhoan_donhangcuatoi;
    GridView gridView;
    ArrayList<donhangcuatui_taikhoan_getter_setter> arrayList;
    Adapter_donhangcuatoi_taikhoan adapter;
    private String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/get_data_donhang.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_taikhoan_donhangcuatoi = inflater.inflate(R.layout.fragment_donhangcuatoi_taikhoan, container, false);
        initControl();
        initEvent();
        return view_taikhoan_donhangcuatoi;
    }

    private void initEvent() {
        getData();

//        for (int i = 0; i < 10; i++) {
//            arrayList.add(new donhangcuatui_taikhoan_getter_setter("a","1","c"));
//        }
//        adapter = new Adapter_donhangcuatoi_taikhoan(getActivity(),arrayList);
//        gridView.setAdapter(adapter);
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URL_CALL_API_GET_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String id;
                String content;
                String price;
                String date;
                arrayList = new ArrayList();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        id = object.getString("id_dh");
                        content = object.getString("noi_dung_dh");
                        price = object.getString("dongia_dh");
                        date = object.getString("ngay_thang_dh");
                        if (getActivity() != null) {
                            arrayList.add(new donhangcuatui_taikhoan_getter_setter(id, price, content, date));
                            adapter = new Adapter_donhangcuatoi_taikhoan(getActivity(), arrayList);
                            adapter.notifyDataSetChanged();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    gridView.setAdapter(adapter);
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
        gridView = (GridView) view_taikhoan_donhangcuatoi.findViewById(R.id.gridview_donhangcuatoi_taikhoan_tablayoutactivity);
    }

}
