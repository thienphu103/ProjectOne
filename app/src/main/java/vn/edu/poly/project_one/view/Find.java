package vn.edu.poly.project_one.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.FindAdapter;
import vn.edu.poly.project_one.Adapter.ImageAdapter_visit;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.find_getter_setter;

/**
 * Created by ASUS on 11/18/2017.
 */

public class Find extends android.support.v4.app.Fragment {
    View view_find;
    ListView lst_find_xuhuong;
    FindAdapter findAdapter;
    ArrayList<find_getter_setter> mFindArrayList;
    Button btn_cancel_tablayoutactivity;
    EditText ext_find_tablayoutactivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_find = inflater.inflate(R.layout.fragment_find, container, false);
        initControl();
        initEvent();
        initDisplay();
        return view_find;
    }

    private void initControl() {
        lst_find_xuhuong = (ListView) view_find.findViewById(R.id.lst_xuhuong_tablayotactivity);
        btn_cancel_tablayoutactivity = (Button) view_find.findViewById(R.id.btn_cancel_tablayoutactivity);
        ext_find_tablayoutactivity = (EditText) view_find.findViewById(R.id.ext_find_tablayoutactivity);

    }

    private void initEvent() {
        btn_cancel_tablayoutactivity.setVisibility(View.GONE);
        mFindArrayList = new ArrayList<find_getter_setter>();
        mFindArrayList.add(new find_getter_setter("quần áo baby"));
        mFindArrayList.add(new find_getter_setter("giày"));
        mFindArrayList.add(new find_getter_setter("mì gói"));
        mFindArrayList.add(new find_getter_setter("khô gà lá chanh"));
        findAdapter = new FindAdapter(mFindArrayList, getContext());
        lst_find_xuhuong.setAdapter(findAdapter);
        ext_find_tablayoutactivity.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                btn_cancel_tablayoutactivity.setVisibility(View.VISIBLE);
                return false;
            }
        });
        btn_cancel_tablayoutactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_cancel_tablayoutactivity.setVisibility(View.GONE);
            }
        });
    }

    private void initDisplay() {
    }

}
