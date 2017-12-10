package vn.edu.poly.project_one.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import vn.edu.poly.project_one.Adapter.Adapter_sanpham_giohang;
import vn.edu.poly.project_one.Adapter.FindAdapter;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.find_getter_setter;

/**
 * Created by ASUS on 11/18/2017.
 */

public class Find extends Fragment implements View.OnClickListener, TextWatcher {
    View view_find;
    FindAdapter findAdapter;
    ArrayList<find_getter_setter> mFindArrayList;
    Button btn_cancel_tablayoutactivity;
    EditText edt_find_tablayoutactivity;
    private String url = "http://namtnps06077.hol.es/get_data_query.php";
    private String txt_search;
    private RecyclerView mRecyclerView_find;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_find = inflater.inflate(R.layout.fragment_find, container, false);
        initControl();
        initEvent();
        return view_find;
    }

    private void initControl() {
        mRecyclerView_find = (RecyclerView) view_find.findViewById(R.id.lst_xuhuong_tablayotactivity);
        btn_cancel_tablayoutactivity = (Button) view_find.findViewById(R.id.btn_cancel_tablayoutactivity);
        edt_find_tablayoutactivity = (EditText) view_find.findViewById(R.id.edt_find_tablayoutactivity);

    }

    private void initEvent() {
        btn_cancel_tablayoutactivity.setVisibility(View.GONE);
        mFindArrayList = new ArrayList<find_getter_setter>();
        mFindArrayList.add(new find_getter_setter("quần áo baby"));
        mFindArrayList.add(new find_getter_setter("giày"));
        mFindArrayList.add(new find_getter_setter("mì gói"));
        mFindArrayList.add(new find_getter_setter("khô gà lá chanh"));
        findAdapter = new FindAdapter(mFindArrayList, getContext());
        mRecyclerView_find.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView_find.setLayoutManager(layoutManager);
        adapter = new FindAdapter( mFindArrayList,getContext());
        mRecyclerView_find.setAdapter(adapter);
        edt_find_tablayoutactivity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn_cancel_tablayoutactivity.setVisibility(View.VISIBLE);
                return false;
            }
        });
        btn_cancel_tablayoutactivity.setOnClickListener(this);
        edt_find_tablayoutactivity.addTextChangedListener(this);

    }

    private void initDisplay(final String txt_query) {
        if (txt_query.length() == 0){

        } else {
            final RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            final StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray array = new JSONArray(response);
                                JSONObject object = null;
                                String ten_sp = "";
                                for (int i = 0; i < array.length(); i++){
                                    object = array.getJSONObject(i);
                                    ten_sp = object.getString("ten_sp");
                                    mFindArrayList.add(new find_getter_setter(ten_sp));
                                }
//                                Toast.makeText(getActivity(), "" + ten_sp , Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(getActivity(), "Exception " + e, Toast.LENGTH_SHORT).show();
                            }
                            findAdapter.notifyDataSetChanged();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
                    mFindArrayList.add(new find_getter_setter(error.toString()));
                    findAdapter.notifyDataSetChanged();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("txt_search",txt_query);
                    return hashMap;
                }
            };
            requestQueue.add(stringRequest);
        }
        txt_search = edt_find_tablayoutactivity.getText().toString().trim();

    }

    @Override
    public void onClick(View view) {
//        if (view.getId() == R.id.btn_cancel_tablayoutactivity){
//            initDisplay();
//            btn_cancel_tablayoutactivity.setVisibility(View.GONE);
//        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        mFindArrayList.clear();
        findAdapter.notifyDataSetChanged();
        txt_search = edt_find_tablayoutactivity.getText().toString().trim();
        initDisplay(txt_search);

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
