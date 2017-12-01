package vn.edu.poly.project_one.view.View_taikhoan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import vn.edu.poly.project_one.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ASUS on 11/28/2017.
 */

public class HoSoCuaToi_TaiKhoan extends Fragment {
    View view_taikhoan_hosocuatoi;
    EditText name, email;
    ImageView img;
    TextView name_img;
    private String url;
    private String email_text;
    RelativeLayout relativeLayout;
    private TextView txt_change_pass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view_taikhoan_hosocuatoi = inflater.inflate(R.layout.fragment_hosocuatoi_taikhoan, container, false);
        initControl();
        initEvent();
        return view_taikhoan_hosocuatoi;
    }

    private void initEvent() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("name_login", MODE_PRIVATE);
        String user = sharedPreferences.getString("username", null);
        url = sharedPreferences.getString("url", null);
        email_text = sharedPreferences.getString("email", null);
        if (user != null) {
            Log.d("ContentLogin", user + " " + url + ""+email_text);
            if (url == null) {
                url = String.valueOf(R.drawable.img_no_avatar);//null
            } else {
                Picasso.with(getContext())
                        .load(url)
                        .resize(67, 67)
                        .error(R.drawable.img_no_avatar)//load url error
                        .placeholder(R.drawable.img_no_avatar)//load url error
                        .into(img);
            }
            String textBold = "Xin chào, " + "<b>" + user + "</b> !";
            name_img.setText(Html.fromHtml(textBold));
            email.setText(email_text);
            name.setText(user);
            name.setFocusable(false);
            name.setClickable(false);
            email.setFocusable(false);
            email.setClickable(false);
            final Animation slideOpen = AnimationUtils.loadAnimation(getContext(), R.anim.anim_verticall);
            final Animation slideClose = AnimationUtils.loadAnimation(getContext(), R.anim.anim_verticall);
            relativeLayout.setVisibility(View.GONE);
            txt_change_pass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (relativeLayout.getVisibility() == View.VISIBLE) {
                        relativeLayout.setVisibility(View.GONE);
                        relativeLayout.startAnimation(slideClose);
                    } else {
                        relativeLayout.setVisibility(View.VISIBLE);
                        relativeLayout.startAnimation(slideOpen);

                    }
                }
            });


        }

    }

    private void initControl() {
        name = (EditText) view_taikhoan_hosocuatoi.findViewById(R.id.txt_name_hosocuatui);
        email = (EditText) view_taikhoan_hosocuatoi.findViewById(R.id.txt_email_hosocuatui);
        img = (ImageView) view_taikhoan_hosocuatoi.findViewById(R.id.img_user_hosocuatui);
        name_img = (TextView) view_taikhoan_hosocuatoi.findViewById(R.id.txt_name_img_hosocuatui);
        relativeLayout = (RelativeLayout) view_taikhoan_hosocuatoi.findViewById(R.id.layout_change_pass);
        txt_change_pass = (TextView) view_taikhoan_hosocuatoi.findViewById(R.id.txt_change_pass);


    }


}
