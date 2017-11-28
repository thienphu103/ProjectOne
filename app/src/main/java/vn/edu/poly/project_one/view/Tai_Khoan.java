package vn.edu.poly.project_one.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import vn.edu.poly.project_one.LoginActivity;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.view.View_taikhoan.DonHangcuaToi_TaiKhoan;
import vn.edu.poly.project_one.view.view_visit.visit_hangmoi_kieudanhsach;

/**
 * Created by ASUS on 11/18/2017.
 */

public class Tai_Khoan extends Fragment {
    View view_taikhoan;
    RelativeLayout relativeLayout;
    Button btn_login,btn_signup;
    int i = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_taikhoan = inflater.inflate(R.layout.fragment_taikhoan, container, false);
        initControl();
        initOnClick();
        initEvent();
        return view_taikhoan;
    }

    private void initControl() {
        relativeLayout = (RelativeLayout) view_taikhoan.findViewById(R.id.rtl_donhangcuatoi_taikhoan);
        btn_login = (Button) view_taikhoan.findViewById(R.id.btn_login_taikhoan_tablayoutactivity);
        btn_signup= (Button) view_taikhoan.findViewById(R.id.btn_signup_taikhoan_tablayoutactivity);
    }

    private void initEvent() {

         if (i == 1){
            btn_signup.setVisibility(View.INVISIBLE);
            btn_login.setVisibility(View.INVISIBLE);
        }

    }

    private void initOnClick() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonHangcuaToi_TaiKhoan DonHangcuaToi_TaiKhoan=new DonHangcuaToi_TaiKhoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_taikhoan, DonHangcuaToi_TaiKhoan);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), LoginActivity.class);
//                startActivity(intent);
                i=1;
                initEvent();
            }
        });
    }
}
