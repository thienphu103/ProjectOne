package vn.edu.poly.project_one.view.view_visit;


import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
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

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.MyAdapter_visit_hangbanchay;
import vn.edu.poly.project_one.Details;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangbanchay_getter_setter;
import vn.edu.poly.project_one.view.ViSit;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 11/20/2017.
 */

public class visit_hangbanchay extends Fragment {
    View view_visit_hangbanchay;
    GridView gridView;
    MyAdapter_visit_hangbanchay adapter;
    ArrayList<visit_hangbanchay_getter_setter> arrayList;
    ImageView img_kieudanhsach;
    ImageView img_gridview_visit_hangbanchay_tablayoutactivity;
    public static final String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/get_data_sanpham.php";
    private FragmentManager fm;
    private RelativeLayout layout_back_hangbanchay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit_hangbanchay = inflater.inflate(R.layout.fragment_thamquan_hangbanchay, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_visit_hangbanchay;
    }

    private void initOnClick() {
        img_kieudanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangbanchay_kieulietke visit_view = new visit_hangbanchay_kieulietke();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangbanchay, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }

    private void initControl() {
        img_kieudanhsach = (ImageView) view_visit_hangbanchay.findViewById(R.id.img_kieudanhsachlietke_visit_hangbanchay_tablayoutactivity);
        layout_back_hangbanchay = (RelativeLayout) view_visit_hangbanchay.findViewById(R.id.layout_back_hangbanchay);
        gridView = (GridView) view_visit_hangbanchay.findViewById(R.id.gridview_visit__hangbanchay_tablayoutactivity);
        layout_back_hangbanchay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViSit visit_view = new ViSit();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangbanchay, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                return false;
            }
        });
        getData();
//        arrayList = new ArrayList<>();
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangbanchay_getter_setter(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        adapter = new MyAdapter_visit_hangbanchay(getContext(),arrayList);
//        gridView.setAdapter(adapter);

    }

    private void initEvent() {

//        FragmentManager fm = getFragmentManager();
//        visit_hangbanchay visit_hangbanchay  = (visit_hangbanchay) fm.findFragmentById(R.id.fragment_visit_hangbanchay);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.hide( visit_hangbanchay);
//        ft.commit();
    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, URL_CALL_API_GET_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String name = "";
                String image;
                String price;
                String id;
                arrayList = new ArrayList<>();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        name = object.getString("ten_sp");
                        image = object.getString("hinhanh_sp");
                        price = object.getString("gia_sp");
                        id = object.getString("id_sp");
                        Log.d("URl_IMAGE", image);
                        arrayList.add(new visit_hangbanchay_getter_setter(
                                image, name, price, id));
                        adapter = new MyAdapter_visit_hangbanchay(getContext(), arrayList);
                        adapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    gridView.setAdapter(adapter);
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            String pattern = "###,###.###";
                            DecimalFormat decimalFormat = new DecimalFormat(pattern);
                            String format = decimalFormat.format(Double.parseDouble(arrayList.get(i).getPrice()));
                            SharedPreferences sharedPreferences = getContext().getSharedPreferences("post_details", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("name_sp", arrayList.get(i).getTitle() + "");
                            editor.putString("gia_sp", arrayList.get(i).getPrice() + "");
                            editor.putString("id_sp", arrayList.get(i).getId() + "");
                            editor.putString("hinhanh_sp", arrayList.get(i).getImg() + "");
//                    editor.putString("soluong",arrayList.get(position).getSoluongconlai_sp()+"");
                            editor.commit();
                            TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
                            tabhost.getTabAt(1).select();
                            Details details = new Details();
                            FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                            ft1.replace(R.id.fragment_hangbanchay, details);
                            ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                            ft1.addToBackStack(null);
                            ft1.commit();
                        }
                    });

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                View view = view_visit_hangbanchay.findViewById(R.id.fragment_hangbanchay);
                final Snackbar snackbar = Snackbar.make(view, "Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);

                // Set an action on it, and a handler
                snackbar.setAction("Thử Lại", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getData();

                    }
                });

                snackbar.show();
                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(arrayRequest);
    }

    public String decodeImage(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteImage = outputStream.toByteArray();
        String encodeImage = Base64.encodeToString(byteImage, Base64.DEFAULT);
        return encodeImage;
    }


}
