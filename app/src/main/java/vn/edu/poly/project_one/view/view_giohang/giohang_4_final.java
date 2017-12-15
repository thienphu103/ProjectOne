package vn.edu.poly.project_one.view.view_giohang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import vn.edu.poly.project_one.LoginActivity;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.view.ViSit;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_4_final extends Fragment {
    View view_final;
    private SharedPreferences sharedPreferences;
    private String email;
    private TextView txt_email;
    private Button btn_dangkythanhvien_giohang;
    private Button btn_trovethamquan_giohang;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_final = inflater.inflate(R.layout.fragment_4_final_giohang, container, false);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        return view_final;
    }

    private void initOnClick() {
        btn_dangkythanhvien_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_trovethamquan_giohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
                tabhost.getTabAt(1).select();
                ViSit visit_view = new ViSit();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_4_final_giohang, visit_view);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    private void initDisplay() {
    }

    private void initEvent() {
        sharedPreferences = getContext().getSharedPreferences("post_details_bull", MODE_PRIVATE);
        email = sharedPreferences.getString("email", null);
        txt_email.setText(email);
    }

    private void initControl() {
        txt_email =(TextView) view_final.findViewById(R.id.txt_email_final_giohang);
        btn_dangkythanhvien_giohang=(Button) view_final.findViewById(R.id.btn_dangkythanhvien_giohang);
        btn_trovethamquan_giohang=(Button) view_final.findViewById(R.id.btn_trovethamquan_giohang);

    }
}
