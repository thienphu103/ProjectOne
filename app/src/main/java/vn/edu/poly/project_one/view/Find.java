package vn.edu.poly.project_one.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import vn.edu.poly.project_one.Adapter.FindAdapter;
import vn.edu.poly.project_one.Details;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.find_getter_setter;

/**
 * Created by ASUS on 11/18/2017.
 */

public class Find extends Fragment implements View.OnClickListener, TextWatcher {
    private View.OnClickListener click;
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
    private ViewPager mViewPager;
    private FragmentManager fragmentManager;
    private int index_back_fragment;
    private FragmentManager fm;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_find = inflater.inflate(R.layout.fragment_find, container, false);
        initControl();
        initEvent();
        init_check_fragment();
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
//        mFindArrayList.add(new find_getter_setter("quần áo baby"));
//        mFindArrayList.add(new find_getter_setter("giày"));
//        mFindArrayList.add(new find_getter_setter("mì gói"));
//        mFindArrayList.add(new find_getter_setter("khô gà lá chanh"));
        findAdapter = new FindAdapter(mFindArrayList, getContext(), click);
        mRecyclerView_find.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView_find.setLayoutManager(layoutManager);
        adapter = new FindAdapter(mFindArrayList, getContext(), click);
        mRecyclerView_find.setAdapter(adapter);
        edt_find_tablayoutactivity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn_cancel_tablayoutactivity.setVisibility(View.VISIBLE);
                return false;
            }
        });
        btn_cancel_tablayoutactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_find_tablayoutactivity.setText("");
            }
        });
        edt_find_tablayoutactivity.addTextChangedListener(this);
        click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("index_tab", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences_index.edit();
//                editor.putInt("index", 3);
//                editor.commit();
//                TabLayOutActivity tabLayOutActivity=new TabLayOutActivity();
//                tabLayOutActivity.ChangeTab();
//                Toast.makeText(getContext(),"Click",Toast.LENGTH_LONG).show();
                TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
                tabhost.getTabAt(1).select();
                Details details = new Details();
                FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.replace(R.id.fragmelayout_visit, details);
                ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft1.addToBackStack(null);
                ft1.commit();
            }
        };
        view_find.setFocusableInTouchMode(true);
        view_find.requestFocus();
        view_find.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
                    tabhost.getTabAt(0).select();
                    return true;
                }
                return false;
            }
        });
    }

    public void init_check_fragment() {
        view_find.setFocusableInTouchMode(true);
        view_find.requestFocus();
        fm = getActivity().getSupportFragmentManager();
        index_back_fragment = fm.getBackStackEntryCount() + 2;
        view_find.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    index_back_fragment--;
                    if (index_back_fragment == 0) {
                        Toast.makeText(getContext(), "Nhấn Lần Nữa Để Về Home", Toast.LENGTH_LONG).show();
                    }
                    try {
                        if (index_back_fragment > 0) {
                            getActivity().getSupportFragmentManager().popBackStackImmediate();
                        }
                        if (index_back_fragment < 0) {
                            TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
                            tabhost.getTabAt(0).select();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    return true;
                }
                return false;
            }
        });
    }

    private void initDisplay(final String txt_query) {
        if (txt_query.length() == 0) {

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
                                String image;
                                String price;
                                String id;
                                for (int i = 0; i < array.length(); i++) {
                                    object = array.getJSONObject(i);
                                    ten_sp = object.getString("ten_sp");
                                    image = object.getString("hinhanh_sp");
                                    price = object.getString("gia_sp");
                                    id = object.getString("id_sp");
                                    mFindArrayList.add(new find_getter_setter(ten_sp, image, price, id));
                                }
//                                Toast.makeText(getActivity(), "" + ten_sp , Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(getActivity(), "Exception " + e, Toast.LENGTH_SHORT).show();
                            }
                            if (getActivity() != null) {
                                adapter = new FindAdapter(mFindArrayList, getContext(), click);
                                findAdapter.notifyDataSetChanged();
                                mRecyclerView_find.setAdapter(adapter);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "" + error, Toast.LENGTH_SHORT).show();
                    View view = view_find.findViewById(R.id.fragmelayout_find);
                    final Snackbar snackbar = Snackbar.make(view, "Không Có Kết Nối Internet.", Snackbar.LENGTH_INDEFINITE);

                    // Set an action on it, and a handler
                    snackbar.setAction("Thử Lại", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            initDisplay("");

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
        adapter = new FindAdapter(mFindArrayList, getContext(), click);
        findAdapter.notifyDataSetChanged();
        txt_search = edt_find_tablayoutactivity.getText().toString().trim();
        initDisplay(txt_search);

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    boolean isOpened = false;


}
