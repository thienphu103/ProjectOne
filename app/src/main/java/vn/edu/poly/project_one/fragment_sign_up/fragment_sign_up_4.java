package vn.edu.poly.project_one.fragment_sign_up;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 11/17/2017.
 */

public class fragment_sign_up_4 extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sign_up_4, container, false);
        FragmentManager fm = getFragmentManager();
        fragment_sign_up_4 fragment_sign_up_4 = (fragment_sign_up_4) fm.findFragmentById(R.id.fragment_4);
        FragmentTransaction ft = fm.beginTransaction();
        ft.hide(fragment_sign_up_4);
        ft.commit();
        initControl();
        initEvent();
        return view;
    }

    private void initControl() {
    }
    private void initEvent() {
    }
}
