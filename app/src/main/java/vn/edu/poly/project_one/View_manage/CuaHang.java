package vn.edu.poly.project_one.View_manage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import vn.edu.poly.project_one.Adapter.Adapter_trungbay_cuahang_manage;
import vn.edu.poly.project_one.Details_Manager;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_1_getter_setter;

public class CuaHang extends Fragment {
    View view_cuahang;
    private View.OnClickListener click;
    private RecyclerView mRecyclerView_cuahang;
    private RecyclerView.Adapter mAdapter_cuahang;
    private RecyclerView.LayoutManager mLayoutManager_cuahang;
    private ArrayList<visit_1_getter_setter> cuahang;
    //Trưng bày
    private RecyclerView mRecyclerView_hangbanchay_cuahang;
    private RecyclerView.Adapter mAdapter_hangbanchay_cuahang;
    private RecyclerView.LayoutManager mLayoutManager_hangbanchay_cuahang;
    private ArrayList<visit_1_getter_setter> hangbanchay_cuahang;
    // Hàng bán chạy
    private RecyclerView mRecyclerView_hangmoi_cuahang;
    private RecyclerView.Adapter mAdapter_hangmoi_cuahang;
    private RecyclerView.LayoutManager mLayoutManager_hangmoi_cuahang;
    private ArrayList<visit_1_getter_setter> hangmoi_cuahang;
    public static final String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/get_data_query_sanpham_by_id.php";
    private String txt_user;

    // Hàng mới
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view_cuahang = inflater.inflate(R.layout.fragment_cua_hang, container, false);
        initControl();
        initEvent();
        return view_cuahang;
    }

    private void initEvent() {
        cuahang = new ArrayList<>();
        hangbanchay_cuahang=new ArrayList<>();
        hangmoi_cuahang=new ArrayList<>();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("name_login", Context.MODE_PRIVATE);
        txt_user = sharedPreferences.getString("id_user", null);
        getData(txt_user);
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                Intent intent = new Intent(getActivity(), TabLayOutActivity.class);
//                startActivity(intent);
//                getActivity().overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
//
//                TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
//                tabhost.getTabAt(1).select();
                Details_Manager details = new Details_Manager();
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.fragment_cuahang_manage, details);
                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft1.addToBackStack(null);
                ft1.commit();

//                Details details = new Details();
//                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
//                ft1.replace(R.id.fragmelayout_visit, details);
//                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                ft1.addToBackStack(null);
//                ft1.commit();
            }
        };
////        for(int i = 0 ; i < 10 ;i++){
////           cuahang.add(new visit_1_getter_setter());
////
////        }
//        hangbanchay_cuahang = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            hangbanchay_cuahang.add(new visit_1_getter_setter());
//
//        }
//        hangmoi_cuahang = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            hangmoi_cuahang.add(new visit_1_getter_setter());
//
//        }
//
        mRecyclerView_cuahang.setHasFixedSize(true);
        mLayoutManager_cuahang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView_cuahang.setLayoutManager(mLayoutManager_cuahang);
//        mAdapter_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),cuahang);
//        mRecyclerView_cuahang.setAdapter(mAdapter_cuahang);
        // Trưng bày
        mRecyclerView_hangbanchay_cuahang.setHasFixedSize(true);
        mLayoutManager_hangbanchay_cuahang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView_hangbanchay_cuahang.setLayoutManager(mLayoutManager_hangbanchay_cuahang);
//        mAdapter_hangbanchay_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),hangbanchay_cuahang,click);
//        mRecyclerView_hangbanchay_cuahang.setAdapter(mAdapter_hangbanchay_cuahang);
        // Hàng bán chạy
        mRecyclerView_hangmoi_cuahang.setHasFixedSize(true);
        mLayoutManager_hangmoi_cuahang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView_hangmoi_cuahang.setLayoutManager(mLayoutManager_hangmoi_cuahang);
//        mAdapter_hangmoi_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),hangmoi_cuahang,click);
//        mRecyclerView_hangmoi_cuahang.setAdapter(mAdapter_hangmoi_cuahang);
        //Hàng mới
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
                                String name = "";
                                String image;
                                String price;
                                String id;
                                String number;
                                for (int i = 0; i < array.length(); i++) {
                                    object = array.getJSONObject(i);
                                    name = object.getString("ten_sp");
                                    image = object.getString("hinhanh_sp");
                                    price = object.getString("gia_sp");
                                    number = object.getString("soluongconlai_sp");
                                    id = object.getString("id_sp");
                                    cuahang.add(new visit_1_getter_setter(Integer.parseInt(id), name, price, image, number));
                                    hangbanchay_cuahang.add(new visit_1_getter_setter(Integer.parseInt(id), name, price, image, number));
                                    hangmoi_cuahang.add(new visit_1_getter_setter(Integer.parseInt(id), name, price, image, number));
//                                    Log.d("IMAGE", name + "" + image + "" + price + "" + id + "" + number);
                                }
//                                Toast.makeText(getActivity(), "" + ten_sp , Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(getActivity(), "Exception " + e, Toast.LENGTH_SHORT).show();
                            }
                            if (getActivity() != null) {
                                mAdapter_cuahang = new Adapter_trungbay_cuahang_manage(getContext(), cuahang, click);
                                mAdapter_hangbanchay_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),hangbanchay_cuahang,click);
                                mAdapter_hangmoi_cuahang= new Adapter_trungbay_cuahang_manage(getContext(),hangmoi_cuahang,click);

                                mAdapter_cuahang.notifyDataSetChanged();
                                mAdapter_hangbanchay_cuahang.notifyDataSetChanged();
                                mAdapter_hangmoi_cuahang.notifyDataSetChanged();

                                mRecyclerView_cuahang.setAdapter(mAdapter_cuahang);
                                mRecyclerView_hangbanchay_cuahang.setAdapter(mAdapter_hangbanchay_cuahang);
                                mRecyclerView_hangmoi_cuahang.setAdapter(mAdapter_hangmoi_cuahang);
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
                    View view = view_cuahang.findViewById(R.id.fragmelayout_find);
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

    private void initControl() {
        mRecyclerView_cuahang = (RecyclerView) view_cuahang.findViewById(R.id.recyclerview_trungbay_cuahang_manage);
        mRecyclerView_hangbanchay_cuahang = (RecyclerView) view_cuahang.findViewById(R.id.recyclerview_hangbanchay_cuahang_manage);
        mRecyclerView_hangmoi_cuahang = (RecyclerView) view_cuahang.findViewById(R.id.recyclerview_hangmoi_cuahang_manage);
    }
}
