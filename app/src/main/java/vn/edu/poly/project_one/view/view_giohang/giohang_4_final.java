package vn.edu.poly.project_one.view.view_giohang;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.edu.poly.project_one.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_4_final extends Fragment {
    View view_final;
    private SharedPreferences sharedPreferences;
    private String email;
    private TextView txt_email;

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
    }
}
