package vn.edu.poly.project_one.view.view_today;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.view.view_visit.visit_hangbanchay_kieulietke;

/**
 * Created by ASUS on 11/23/2017.
 */

public class today_start extends Fragment {
    View view_start;
    Button btn_vao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_start = inflater.inflate(R.layout.fragment_today_start, container, false);
        initControl();
        initEvent();
        initOnClick();
        return view_start;
    }

    private void initOnClick() {
        btn_vao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                today_khaitruong today_khaitruong=new today_khaitruong();
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.fragment_today_start, today_khaitruong);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                ft.addToBackStack(null);
//                ft.commit();
                FragmentManager fragment = getFragmentManager();
                today_khaitruong today_khaitruong = (today_khaitruong) fragment.findFragmentById(R.id.fragment_today_2);
                FragmentTransaction ft = fragment.beginTransaction();
                ft.show(today_khaitruong);
                ft.commit();
            }
        });
    }

    private void initControl() {
        btn_vao = (Button) view_start.findViewById(R.id.btn_today_start_vao);
    }
    private void initEvent() {
    }

}
