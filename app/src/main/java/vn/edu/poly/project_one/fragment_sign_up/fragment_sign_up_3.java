package vn.edu.poly.project_one.fragment_sign_up;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 11/17/2017.
 */

public class fragment_sign_up_3 extends Fragment {
    Button btn_continue_signuactivity_3;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sign_up_3, container, false);
        FragmentManager fm = getFragmentManager();
        fragment_sign_up_3 fragment_sign_up_3 = (fragment_sign_up_3) fm.findFragmentById(R.id.fragment_3);
        FragmentTransaction ft = fm.beginTransaction();
        ft.hide(fragment_sign_up_3);
        ft.commit();
        initControl();
        initEvent();
        return view;
    }

    private void initControl() {
        btn_continue_signuactivity_3 = (Button) view.findViewById(R.id.btn_continue_3_SignUpActivity);
    }
    private void initEvent() {
        btn_continue_signuactivity_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fragment_sign_up_4 fragment_sign_up_4 = (fragment_sign_up_4) fm.findFragmentById(R.id.fragment_4);
                FragmentTransaction ft = fm.beginTransaction();
//                ft.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
//                Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.slide_in_up);
                ft.show(fragment_sign_up_4);
                ft.commit();
            }
        });
    }
}
