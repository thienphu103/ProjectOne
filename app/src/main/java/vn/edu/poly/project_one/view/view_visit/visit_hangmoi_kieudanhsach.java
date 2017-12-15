package vn.edu.poly.project_one.view.view_visit;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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

import vn.edu.poly.project_one.Adapter.Adapter_visit_hangmoi_kieudanhsach;
import vn.edu.poly.project_one.Details;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.visit_hangmoi_getter_setter_kieudanhsach;
import vn.edu.poly.project_one.view.ViSit;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 11/23/2017.
 */

public class visit_hangmoi_kieudanhsach extends Fragment  {
    View view_visit_hangmoi_kieudanhsach;
    GridView gridView;
    Adapter_visit_hangmoi_kieudanhsach adapter;
    ArrayList<visit_hangmoi_getter_setter_kieudanhsach> arrayList;
    ImageView img_kieudanhsach;
    public static final String URL_CALL_API_GET_DATA = "http://namtnps06077.hol.es/get_data_sp_moi_nhat.php";
    private RelativeLayout layout_back_hangmoi_kieudanhsach;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_visit_hangmoi_kieudanhsach = inflater.inflate(R.layout.fragment_visit_hangmoi_kieudanhsach, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_visit_hangmoi_kieudanhsach;
    }

    private void initEvent() {
        getData();
//        arrayList = new ArrayList<>();
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        arrayList.add(new
//                visit_hangmoi_getter_setter_kieudanhsach(R.drawable.giay,
//                getResources().getString(R.string.txt_tenhang_tablayoutactivity),
//                getResources().getString(R.string.txt_gia_tablayoutactivity)));
//        adapter = new Adapter_visit_hangmoi_kieudanhsach(getActivity(),arrayList);
//        gridView.setAdapter(adapter);
    }

    private void initControl() {
        img_kieudanhsach = (ImageView) view_visit_hangmoi_kieudanhsach.findViewById(R.id.img_kieudanhsachlietke_visit_hangmoi_kieudanhsach_tablayoutactivity);
        gridView = (GridView) view_visit_hangmoi_kieudanhsach.findViewById(R.id.gridview_visit_hangmoi_kieudanhsach);
        layout_back_hangmoi_kieudanhsach=(RelativeLayout) view_visit_hangmoi_kieudanhsach.findViewById(R.id.layout_back_hangmoi_kieudanhsach);
        layout_back_hangmoi_kieudanhsach.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViSit visit_view = new ViSit();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangmoi_kieudanhsach, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                return false;
            }
        });

    }

    private void initOnClick() {
        img_kieudanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visit_hangmoi_kieulietke visit_view = new visit_hangmoi_kieulietke();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_hangmoi_kieudanhsach, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

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
                        id=object.getString("id_sp");

                        Log.d("URl_IMAGE", image);
                        arrayList.add(new
                                visit_hangmoi_getter_setter_kieudanhsach(image,
                                name, price,id));
                        adapter = new Adapter_visit_hangmoi_kieudanhsach(getActivity(),arrayList);
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
                            ft1.replace(R.id.fragment_hangmoi_kieudanhsach, details);
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
                Toast.makeText(getContext(), "" + error.toString(), Toast.LENGTH_SHORT).show();
                View view = view_visit_hangmoi_kieudanhsach.findViewById(R.id.fragment_hangmoi_kieudanhsach);
                final Snackbar snackbar = Snackbar.make(view, "Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);

                // Set an action on it, and a handler
                snackbar.setAction("Thử Lại", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getData();

                    }
                });

                snackbar.show();
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
