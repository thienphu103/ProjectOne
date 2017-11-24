package vn.edu.poly.project_one.view.view_today;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.edu.poly.project_one.Adapter.Adapter_khaitruong_today;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.View_getter_setter.today_khaitruong_setter_getter;

/**
 * Created by ASUS on 11/23/2017.
 */

public class today_custom3 extends Fragment {
    private static final long SPLASH_DISPLAY_LENGTH = 500;
    View view_custom3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_custom3 = inflater.inflate(R.layout.fragment_today_custom3, container, false);
        FragmentManager fragment = getFragmentManager();
        today_custom3 today_custom3 = (today_custom3) fragment.findFragmentById(R.id.fragment_today_3);
        FragmentTransaction ft = fragment.beginTransaction();
        ft.hide(today_custom3);
        ft.commit();
        initControl();
        initEvent();
        return view_custom3;
    }

    private void initControl() {
    }
    private void initEvent() {
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                /* Create an Intent that will start the Menu-Activity. */
//                Intent mainIntent = new Intent(getActivity(),today_start.class);
//                getActivity().startActivity(mainIntent);
//                getActivity().finish();
//            }
//        }, SPLASH_DISPLAY_LENGTH);
    }

}
