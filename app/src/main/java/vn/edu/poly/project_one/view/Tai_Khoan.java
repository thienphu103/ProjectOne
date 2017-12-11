package vn.edu.poly.project_one.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import vn.edu.poly.project_one.LoginActivity;
import vn.edu.poly.project_one.R;
import vn.edu.poly.project_one.SignUpActivity;
import vn.edu.poly.project_one.view.View_taikhoan.DanhSachMongMuon_TaiKhoan;
import vn.edu.poly.project_one.view.View_taikhoan.DanhSachYeuThich_TaiKhoan;
import vn.edu.poly.project_one.view.View_taikhoan.DonHangcuaToi_TaiKhoan;
import vn.edu.poly.project_one.view.View_taikhoan.HoSoCuaToi_TaiKhoan;


/**
 * Created by ASUS on 11/18/2017.
 */

public class Tai_Khoan extends Fragment {
    View view_taikhoan;
    RelativeLayout rtl_donhangcuatoi, rtl_danhsachyeuthich, rtl_danhsachmongmuon, rtl_hosocuatoi;
    Button btn_login, btn_signup;
    TextView txt_login_name, txt_logout;
    ImageView img_login;
    int i = 0;
    String url = "";
    private Object MY_PREFS_NAME = "user_name";
    private int MODE_PRIVATE = 0;
    private SharedPreferences sharedPreferences;
    private FragmentManager fragmentManager;
    private int index_back_fragment;
    private FragmentManager fm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_taikhoan = inflater.inflate(R.layout.fragment_taikhoan, container, false);
        initControl();
        initOnClick();
        initEvent();
        init_check_fragment();
        return view_taikhoan;
    }

    private void initControl() {
        rtl_donhangcuatoi = (RelativeLayout) view_taikhoan.findViewById(R.id.rtl_donhangcuatoi_taikhoan);
        rtl_hosocuatoi = (RelativeLayout) view_taikhoan.findViewById(R.id.rtl_hosocuatoi_taikhoan);
        rtl_danhsachyeuthich = (RelativeLayout) view_taikhoan.findViewById(R.id.rtl_danhsachyeuthich_taikhoan);
        rtl_danhsachmongmuon = (RelativeLayout) view_taikhoan.findViewById(R.id.rtl_danhsachmongmuon_taikhoan);
        btn_login = (Button) view_taikhoan.findViewById(R.id.btn_login_taikhoan_tablayoutactivity);
        btn_signup = (Button) view_taikhoan.findViewById(R.id.btn_signup_taikhoan_tablayoutactivity);
        txt_login_name = (TextView) view_taikhoan.findViewById(R.id.txt_login_taikhoan_tablayoutactivity);
        img_login = (ImageView) view_taikhoan.findViewById(R.id.img_login_taikhoan_tablayoutactivity);
        txt_logout = (TextView) view_taikhoan.findViewById(R.id.txt_logout);

    }

    private void initEvent() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("name_login", MODE_PRIVATE);
        String user = sharedPreferences.getString("username", null);
        url = sharedPreferences.getString("url", null);
        if (user != null) {
            Log.d("ContentLogin", user + " " + url + "");
            if (url == null) {
                url = String.valueOf(R.drawable.img_no_avatar);//null
            } else {
                Picasso.with(getContext())
                        .load(url)
                        .resize(67, 67)
                        .error(R.drawable.img_no_avatar)//load url error
                        .placeholder(R.drawable.img_no_avatar)//load url error
                        .into(img_login);
            }
            String textBold = "Xin chào, " + "<b>" + user + "</b> !";
            txt_login_name.setText(Html.fromHtml(textBold));
            btn_signup.setVisibility(View.INVISIBLE);
            btn_login.setVisibility(View.INVISIBLE);
            txt_logout.setAlpha(1);
            txt_logout.setEnabled(true);
        }else{
            txt_logout.setAlpha((float) 0.3);
            txt_logout.setEnabled(false);
        }
    }

    private void initOnClick() {
        rtl_donhangcuatoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DonHangcuaToi_TaiKhoan DonHangcuaToi_TaiKhoan = new DonHangcuaToi_TaiKhoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_taikhoan, DonHangcuaToi_TaiKhoan, "sometag");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
                init_check_fragment();
            }
        });
        rtl_danhsachyeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DanhSachYeuThich_TaiKhoan DanhSachYeuThich_TaiKhoan = new DanhSachYeuThich_TaiKhoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_taikhoan, DanhSachYeuThich_TaiKhoan);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        rtl_danhsachmongmuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DanhSachMongMuon_TaiKhoan DanhSachMongMuon_TaiKhoan = new DanhSachMongMuon_TaiKhoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_taikhoan, DanhSachMongMuon_TaiKhoan);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();

            }
        });
        rtl_hosocuatoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoSoCuaToi_TaiKhoan HoSoCuaToi_TaiKhoan = new HoSoCuaToi_TaiKhoan();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_taikhoan, HoSoCuaToi_TaiKhoan);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

                i = 1;
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(intent);

            }

        });
        txt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();

            }
        });


    }

    public void init_check_fragment() {
        view_taikhoan.setFocusableInTouchMode(true);
        view_taikhoan.requestFocus();
        fm = getActivity().getSupportFragmentManager();
        index_back_fragment = fm.getBackStackEntryCount() + 2;
        view_taikhoan.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    index_back_fragment--;
                    if(index_back_fragment==0){
                        Toast.makeText(getContext(),"Nhấn Lần Nữa Để Về Home",Toast.LENGTH_LONG).show();
                    }
                    try {
                        if (index_back_fragment > 0) {
                            getActivity().getSupportFragmentManager().popBackStackImmediate();
                        }
                        if (index_back_fragment < 0) {
                            TabLayout tabhost = (TabLayout) getActivity().findViewById(R.id.tabs);
                            tabhost.getTabAt(0).select();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    return true;
                }
                return false;
            }
        });
    }

    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("App");
        builder.setMessage("Bạn có muốn đăng xuất không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                btn_signup.setVisibility(View.VISIBLE);
                btn_login.setVisibility(View.VISIBLE);
                txt_logout.setAlpha((float) 0.3);
                txt_logout.setEnabled(false);
                sharedPreferences = getActivity().getSharedPreferences("name_login", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

}
