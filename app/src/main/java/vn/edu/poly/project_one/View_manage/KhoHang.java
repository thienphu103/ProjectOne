package vn.edu.poly.project_one.View_manage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import vn.edu.poly.project_one.Adapter.Adapter_Khohang;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

import static android.content.Context.MODE_PRIVATE;

public class KhoHang extends Fragment {
    private View.OnClickListener click,click2;
    View view_khohang;
    ListView listView;
    ArrayList<visit_1_getter_setter> arrayList;
    Adapter_Khohang adapter_khohang;
    private Button btn_nhaphang_khohang;
    public static final String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/get_data_query_sanpham_by_id.php";
    private String txt_user;
    private String txt_id_sp;
    private ArrayList<visit_1_getter_setter> arrayListShow;
    private Adapter_Khohang adapter;
    private int index_listview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_khohang = inflater.inflate(R.layout.fragment_kho_hang, container, false);
        initControl();
        initEvent();
        return view_khohang;
    }

    private void initEvent() {
        arrayList = new ArrayList<visit_1_getter_setter>();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("name_login", Context.MODE_PRIVATE);
        txt_user = sharedPreferences.getString("id_user", null);

        SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("get_index_list_view_kho_hang", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences_index.edit();
        getData(txt_user);
        btn_nhaphang_khohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("check_click",null);
                editor.commit();
                NhapHang view_nhap_hang = new NhapHang();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_khohang_manage, view_nhap_hang);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NhapHang view_nhap_hang = new NhapHang();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_khohang_manage, view_nhap_hang);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();


            }
        };
        click2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("check_click",null);
                editor.commit();
                NhapHang view_nhap_hang = new NhapHang();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_khohang_manage, view_nhap_hang);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();


            }
        };
    }

    private void initControl() {
        listView = (ListView) view_khohang.findViewById(R.id.lst_khohang);
        btn_nhaphang_khohang = (Button) view_khohang.findViewById(R.id.btn_nhaphang_khohang);
    }

    private void getData(final String txt_query) {
        if (txt_query.length() == 0) {

        } else {
            final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_CALL_API_GET_DATA,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray array = new JSONArray(response);
                                JSONObject object = null;
                                String ten_sp = "";
                                String image;
                                String price;
                                String id;
                                String id_sp;
                                for (int i = 0; i < array.length(); i++) {
                                    object = array.getJSONObject(i);
                                    ten_sp = object.getString("ten_sp");
                                    image = object.getString("hinhanh_sp");
                                    price = object.getString("soluongconlai_sp");
                                    id = object.getString("id_shop");
                                    id_sp = object.getString("id_sp");

                                    arrayList.add(new visit_1_getter_setter(Integer.parseInt(id_sp), ten_sp, price, image, price));
                                    Log.d("IMAGE", image + "");
                                }
//                                Toast.makeText(getActivity(), "" + ten_sp , Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(getActivity(), "Exception " + e, Toast.LENGTH_SHORT).show();
                            }
                            if (getActivity() != null) {
                                adapter = new Adapter_Khohang(getContext(), arrayList, click,click2);
                                adapter.notifyDataSetChanged();
                                listView.setAdapter(adapter);
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
                    View view = view_khohang.findViewById(R.id.fragmelayout_find);
                    final Snackbar snackbar = Snackbar.make(view, "Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);

                    // Set an action on it, and a handler
                    snackbar.setAction("Thử Lại", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getData("");

                        }
                    });

                    snackbar.show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("txt_search", txt_query);
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);
        }
//        txt_search = edt_find_tablayoutactivity.getText().toString().trim();

    }

}
