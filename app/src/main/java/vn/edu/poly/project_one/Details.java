package vn.edu.poly.project_one;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class Details extends Fragment {
    private View view_details;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_details = inflater.inflate(R.layout.fragment_detail, container, false);

        initControl();
        initOnClick();
        initEvent();
        return view_details;
    }

    private void initEvent() {
//        SharedPreferences sharedPreferences = getContext().getSharedPreferences("name_test", MODE_PRIVATE);
//        String user = sharedPreferences.getString("username_test", null);
//        Toast.makeText(getContext(),user+"",Toast.LENGTH_SHORT).show();
        // Lấy dữ liệu từ Adapter;
    }

    private void initOnClick() {
    }

    private void initControl() {

    }

}
