package vn.edu.poly.project_one;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    RelativeLayout txt_signup_loginactivity;
    Button btn_login_loginactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
        initControl();
        initEvent();
        initDisplay();
    }
    private void initControl() {
        txt_signup_loginactivity = (RelativeLayout) findViewById(R.id.txt_signup_loginactivity);
        btn_login_loginactivity = (Button) findViewById(R.id.btn_login_LoginActivity);
    }
    private void initEvent() {
        txt_signup_loginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            }
        });
        btn_login_loginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,TabLayOutActivity.class);

            }
        });
    }
    private void initDisplay() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
