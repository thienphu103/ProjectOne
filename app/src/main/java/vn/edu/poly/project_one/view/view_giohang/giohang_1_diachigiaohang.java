package vn.edu.poly.project_one.view.view_giohang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.edu.poly.project_one.R;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_1_diachigiaohang extends Fragment {
    Button btn_continue;
    View view_diachigiaohang;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_diachigiaohang = inflater.inflate(R.layout.fragment_1_diachigiaohang_giohang, container, false);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        return view_diachigiaohang;
    }

    private void initOnClick() {
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giohang_2_thanhtoan giohang_2_thanhtoan =new giohang_2_thanhtoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_1_diachigiaohang, giohang_2_thanhtoan);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    private void initDisplay() {
    }

    private void initEvent() {
    }

    private void initControl() {
        btn_continue = (Button) view_diachigiaohang.findViewById(R.id.btn_continue_diachigiaohang_giohang);
    }

}
