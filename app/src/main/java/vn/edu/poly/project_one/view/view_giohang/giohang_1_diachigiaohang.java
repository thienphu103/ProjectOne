package vn.edu.poly.project_one.view.view_giohang;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.poly.project_one.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 12/1/2017.
 */

public class giohang_1_diachigiaohang extends Fragment {
    Button btn_continue;
    View view_diachigiaohang;
    EditText ten, email, sdt, tinh, quan, xa, sonha;
    String txt_ten, txt_email, txt_sdt, txt_tinh, txt_quan, txt_xa, txt_sonha;
    private String diachi_post;
    private String email_post;
    private String ten_post;

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
                txt_ten = ten.getText().toString();
                txt_email = email.getText().toString();
                txt_sdt = sdt.getText().toString();
                txt_tinh = tinh.getText().toString();
                txt_quan = quan.getText().toString();
                txt_xa = xa.getText().toString();
                txt_sonha = sonha.getText().toString();
                if (!(txt_ten.isEmpty())
                        && !(txt_email.isEmpty())
                        && !(txt_sdt.isEmpty())
                        && !(txt_tinh.isEmpty())
                        && !(txt_quan.isEmpty())
                        && !(txt_xa.isEmpty())
                        && !(txt_sonha.isEmpty())) {

                    diachi_post=txt_tinh+" "+txt_quan+" "+txt_xa+" "+txt_sonha;
                    email_post=txt_email;
                    ten_post=txt_ten;
                    SharedPreferences sharedPreferences_index = getContext().getSharedPreferences("post_details_bull", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences_index.edit();
                    editor.putString("diachi", diachi_post);
                    editor.putString("email", email_post);
                    editor.putString("ten", ten_post);
                    editor.putString("sdt",txt_sdt);
                    editor.commit();
                    giohang_2_thanhtoan giohang_2_thanhtoan = new giohang_2_thanhtoan();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_1_diachigiaohang, giohang_2_thanhtoan);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();
                } else {
//
                    if ((txt_ten.isEmpty())) {
                        ten.setHint("*Xin vui lòng không bỏ trống");
                        ten.setHintTextColor(Color.RED);
                    }
                    if ((txt_email.isEmpty())) {
                        email.setHint("*Xin vui lòng không bỏ trống");
                        email.setHintTextColor(Color.RED);
                    }
                    if ((txt_sdt.isEmpty())) {
                        sdt.setHint("*Xin vui lòng không bỏ trống");
                        sdt.setHintTextColor(Color.RED);
                    }
                    if ((txt_tinh.isEmpty())) {
                        tinh.setHint("*Xin vui lòng không bỏ trống");
                        tinh.setHintTextColor(Color.RED);
                    }
                    if ((txt_quan.isEmpty())) {
                        quan.setHint("*Xin vui lòng không bỏ trống");
                        quan.setHintTextColor(Color.RED);
                    }
                    if ((txt_xa.isEmpty())) {
                        xa.setHint("*Xin vui lòng không bỏ trống");
                        xa.setHintTextColor(Color.RED);
                    }
                    if ((txt_sonha.isEmpty())) {
                        sonha.setHint("*Xin vui lòng không bỏ trống");
                        sonha.setHintTextColor(Color.RED);
                    }
                }
            }
        });
    }

    private void initDisplay() {
    }

    private void initEvent() {


    }

    private void initControl() {
        btn_continue = (Button) view_diachigiaohang.findViewById(R.id.btn_continue_diachigiaohang_giohang);
        ten = (EditText) view_diachigiaohang.findViewById(R.id.edt_ten_diachigiaohang);
        email = (EditText) view_diachigiaohang.findViewById(R.id.edt_email_diachigiaohang);
        sdt = (EditText) view_diachigiaohang.findViewById(R.id.edt_sdt_diachigiaohang);
        tinh = (EditText) view_diachigiaohang.findViewById(R.id.edt_tinh_diachigiaohang);
        quan = (EditText) view_diachigiaohang.findViewById(R.id.edt_quan_diachigiaohang);
        xa = (EditText) view_diachigiaohang.findViewById(R.id.edt_xa_diachigiaohang);
        sonha = (EditText) view_diachigiaohang.findViewById(R.id.edt_so_nha_diachigiaohang);

    }


}
