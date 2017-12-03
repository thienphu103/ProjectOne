package vn.edu.poly.project_one.view.view_giohang;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import vn.edu.poly.project_one.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_2_thanhtoan extends Fragment {
    View view_thanhtoan;
    Button btn_continue;
    RadioGroup radioGroup;
    private String thanhtoan_post;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_thanhtoan = inflater.inflate(R.layout.fragment_2_thanhtoan_giohang, container, false);
        initControl();
        initEvent();
        initDisplay();
        initOnClick();
        return view_thanhtoan;
    }

    private void initOnClick() {
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int idx = radioGroup.indexOfChild(radioButton);
                RadioButton r = (RadioButton)  radioGroup.getChildAt(idx);
                thanhtoan_post = r.getText().toString();
                SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("post_details_bull", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences_index.edit();
                editor.putString("thanhtoan", thanhtoan_post);
                editor.commit();
                giohang_3_dathang giohang_3_dathang =new giohang_3_dathang();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_thanhtoan_giohang, giohang_3_dathang);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                //;
            }
        });
    }

    private void initDisplay() {
    }

    private void initEvent() {


    }

    private void initControl() {
        btn_continue = (Button) view_thanhtoan.findViewById(R.id.btn_continue_thanhtoan_giohang);
        radioGroup=(RadioGroup) view_thanhtoan.findViewById(R.id.radio_choose_thanhtoan);
    }
}
