package vn.edu.poly.project_one;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import vn.edu.poly.project_one.ControlClass.LoginClass;

import static vn.edu.poly.project_one.SETUP_API.CallApiMySQL.URL_LOCAL_HOST;

public class LoginActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener, View.OnClickListener, View.OnLongClickListener {
    RelativeLayout txt_signup_loginactivity;
    Button btn_login_loginactivity;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private GoogleApiClient mGoogleApiClient;
    private TextView mStatusTextView;
    private TextView mStatusIdTextView;
    private ImageView imageViewAvatar;
    private ProgressDialog mProgressDialog;
    private String url = "http://" + URL_LOCAL_HOST + "//serverlocal/post_data_sign_up.php";
    private String IdUser = "";
    private String NameUser = "";
    private String UrlImageIdUser = "";
    SharedPreferences sharedPreferences;
    String s = "";
    String ss = "";
    private CallbackManager callbackManager;
    private LoginButton loginButton_fb;
    private AccessTokenTracker accessTokenTracker;
    String profile;
    String IdProfileFb = "";
    String imageID = "";
    String UserImageUrl = "";
    Button btn_logout_gg;
    boolean check_fb_login = true;
    private String MY_PREFS_NAME = "name_user";
    private String name_facebook_get_data;
    private String url_facebook_get_data;
    private String email_facebook_get_data;
    private String EmailUser="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        initControl();
        initEvent();
        initDisplay();
        initFacebook();

    }


    private void initControl() {
//        LoginManager.getInstance().logOut();
//        AccessToken.setCurrentAccessToken(null);
        callbackManager = CallbackManager.Factory.create();
        loginButton_fb = (LoginButton) findViewById(R.id.login_button_fb);
        findViewById(R.id.sign_in_button_gg).setOnClickListener(this);
        findViewById(R.id.sign_in_button_gg).setOnLongClickListener(this);
        findViewById(R.id.sign_in_button_fb).setOnClickListener(this);
        txt_signup_loginactivity = (RelativeLayout) findViewById(R.id.txt_signup_loginactivity);
        btn_login_loginactivity = (Button) findViewById(R.id.btn_login_LoginActivity);


    }

    private void initEvent() {
        txt_signup_loginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
            }
        });
        btn_login_loginactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, TabLayOutActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initDisplay() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        mStatusTextView = (TextView) findViewById(R.id.status);
//        mStatusIdTextView = (TextView) findViewById(R.id.statusid);
//        mStatusIdTextView = (TextView) findViewById(R.id.statusid);
//        imageViewAvatar=(ImageView) findViewById(R.id.img_avatar);

        // Button listeners


//        findViewById(R.id.sign_out_button).setOnClickListener(this);
//        findViewById(R.id.disconnect_button).setOnClickListener(this);

        // [START configure_signin]
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // [END configure_signin]

        // [START build_client]
        // Build a GoogleApiClient with access to the Google Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        // [END build_client]

        // [START customize_button]
        // Set the dimensions of the sign-in button.
//        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
//        signInButton.setSize(SignInButton.SIZE_STANDARD);
    }

    //API Google
    @Override
    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
        if (opr.isDone()) {
            // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
            // and the GoogleSignInResult will be available instantly.
            Log.d(TAG, "Got cached sign-in");
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        } else {
            // If the user has not previously signed in on this device or the sign-in has expired,
            // this asynchronous branch will attempt to sign in the user silently.  Cross-device
            // single sign-on will occur in this branch.
            showProgressDialog();
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(GoogleSignInResult googleSignInResult) {
                    hideProgressDialog();
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    // [START onActivityResult]
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    // [END onActivityResult]

    // [START handleSignInResult]
    private void handleSignInResult(GoogleSignInResult result) {


        check_fb_login = false;
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
//            mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
//            mStatusIdTextView.setText(acct.getId());
            IdUser = acct.getId();
            NameUser = acct.getDisplayName();
            EmailUser=acct.getEmail();
            LoginClass loginClass = new LoginClass();
            loginClass.setUser_name_gg(NameUser);
            if (acct.getPhotoUrl() == null) {
                UrlImageIdUser = "https://lh3.googleusercontent.com/H9yAIsZYqbIOh_E1ON90chVhO6SYSD6ucV-XirZXkMFDqLRjGoztobaxx1XS9CB4lfg=w300";

            } else {
                UrlImageIdUser = acct.getPhotoUrl() + "";
            }
//            updateUI(true);
            Log.d("Image", acct.getPhotoUrl() + ""+acct.getEmail());
            sharedPreferences = getSharedPreferences("name_login", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", NameUser);
            editor.putString("url", acct.getPhotoUrl() + "");
            editor.putString("check", null);
            editor.putString("email",EmailUser);
            Toast.makeText(getApplicationContext(), "Saving", Toast.LENGTH_SHORT).show();
            editor.commit();
            signOut();
            revokeAccess();
            if (acct.getDisplayName() != null) {
                showQuestionDialog();
            }
            upData();


        } else {
            // Signed out, show unauthenticated UI.
//            updateUI(false);
        }
    }

    private void upData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(LoginActivity.this, "" + response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "" + error, Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringMap = new HashMap<>();
//                Bitmap bitmap = ((BitmapDrawable)imageViewAvatar.getDrawable()).getBitmap();

                try {
                    URL url_gg = new URL(UrlImageIdUser);
                    Bitmap image_gg = BitmapFactory.decodeStream(url_gg.openConnection().getInputStream());
                    s = decodeImage(image_gg);
                } catch (IOException e) {
                    System.out.println(e);
                }
                stringMap.put("image_name", IdUser);
                stringMap.put("image_fiel", s);
                return stringMap;


            }
        };
        requestQueue.add(stringRequest);
    }

    private void upDataFb() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(LoginActivity.this, "" + response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "" + error, Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> stringMap = new HashMap<>();
//                Bitmap bitmap = ((BitmapDrawable)imageViewAvatar.getDrawable()).getBitmap();
                UserImageUrl = "https://graph.facebook.com/" + IdProfileFb + "" + "/picture?type=large";
                try {
                    URL url_fb = new URL(UserImageUrl);
                    Bitmap image_fb = BitmapFactory.decodeStream(url_fb.openConnection().getInputStream());
                    ss = decodeImage(image_fb);
                } catch (IOException e) {
                    System.out.println(e);
                }
                Log.d("ID_FB", IdProfileFb);
                Log.d("URL_FB", UserImageUrl);
                stringMap.put("image_name", IdProfileFb);
                stringMap.put("image_fiel", ss);
                return stringMap;
            }


        };
        requestQueue.add(stringRequest);
    }
    // [END handleSignInResult]

    // [START signIn]
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // [END signIn]

    // [START signOut]
    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
//                        updateUI(false);

                        // [END_EXCLUDE]
                    }
                });
    }
    // [END signOut]

    // [START revokeAccess]
    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
//                        updateUI(false);
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END revokeAccess]

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
//            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

//    private void updateUI(boolean signedIn) {
//        if (signedIn) {
//            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
//            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
//        } else {
//            mStatusTextView.setText(R.string.signed_out);
//
//            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
//            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
//        }
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button_gg:
                signIn();
                break;
            case R.id.sign_in_button_fb:
                loginButton_fb.performClick();

                break;
//            case R.id.disconnect_button:
//                revokeAccess();
//                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button_gg:
//                showAlertDialog();
                break;
        }
        return false;
    }

    private String decodeImage(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteImage = outputStream.toByteArray();
        String encodeImage = Base64.encodeToString(byteImage, Base64.DEFAULT);
        return encodeImage;
    }

    public void showQuestionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("App");
        builder.setMessage("Bạn có muốn đăng nhập với tên " + NameUser + " không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(LoginActivity.this, TabLayOutActivity.class);
                startActivity(intent);
                finish();
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
    public void showQuestionDialogFb() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("App");
        builder.setMessage("Bạn có muốn đăng nhập với tên " + name_facebook_get_data + " không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(LoginActivity.this, TabLayOutActivity.class);
                startActivity(intent);
                finish();
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
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("App");
        builder.setMessage("Bạn có muốn đăng xuất không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                signOut();
                revokeAccess();
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

    private void initFacebook() {

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().logOut();
//        loginButton_fb.callOnClick();
//        btntxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btntxt.setText("Log Out");
//                // String file =txtPro.getText().toString();
//                FacebookSdk.sdkInitialize(getApplicationContext());
//                LoginManager.getInstance().logOut();
//                AccessToken.setCurrentAccessToken(null);
//            }
//        });
            /* Custom Login button */

        // btnAction = (Button) findViewById(R.id.btnAction);
        loginButton_fb.setReadPermissions(Arrays.asList(
                "public_profile", "email", "user_friends"));


        loginButton_fb.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                IdProfileFb = loginResult.getAccessToken().getUserId();

                graphRequest(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                // App code\


            }

            @Override
            public void onError(FacebookException exception) {
                // App code

            }
        });

        /* Implement to get data from Facebook API
         *
         * Custom Login
          * */

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code

                        graphRequest(loginResult.getAccessToken());

//                        UserImageUrl = "https://graph.facebook.com/" + IdProfileFb + "/picture?type=large";

                    }

                    @Override
                    public void onCancel() {
                        // App code
                        check_fb_login = false;
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        check_fb_login = false;
                    }
                });

//        btnAction.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (AccessToken.getCurrentAccessToken() != null){
//                    LoginManager.getInstance().logOut();
//                    show(false,"Login By Facebook");
//                }
//
//                else{
//
//                    LoginManager.getInstance().logInWithReadPermissions(
//                            MainActivity.this,
//                            Arrays.asList("public_profile","email","user_friends")
//                    );
//
//                }
//            }
//        });

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

                if (currentAccessToken == null) {

                    Toast.makeText(getApplicationContext(), "User log out", Toast.LENGTH_SHORT).show();
                    //show(false,"Login By Facebook");

                } else {
                    check_fb_login = true;

                    Toast.makeText(getApplicationContext(), "User log in", Toast.LENGTH_SHORT).show();


                }
            }
        };

        if (AccessToken.getCurrentAccessToken() != null) {

            graphRequest(AccessToken.getCurrentAccessToken());

        } else {
            // show(false,"Login By Facebook");
        }
    }

    public void parseJson(JSONObject response) {

        try {

            JSONObject json = response;

            String id = json.getString("id");
            String email = json.getString("email");
            String first_name = json.getString("first_name");
            String last_name = json.getString("last_name");
            // show(true,first_name);
            profile = ("ID" + id + "\n"
                    + "Email:" + email + "\n" +
                    "Name: " + first_name + " " + last_name);
            IdProfileFb = json.getString("id");
//            UserImageUrl = "https://graph.facebook.com/" + IdProfileFb + "/picture?type=large";
        } catch (JSONException e) {

        }

    }

    public void graphRequest(AccessToken token) {

        GraphRequest request = GraphRequest.newMeRequest(token, new GraphRequest.GraphJSONObjectCallback() {

            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                parseJson(object);
                JSONObject object1 = response.getJSONObject();

                Log.d("successed", response.toString());
                try {
                    name_facebook_get_data = object1.getString("first_name")+" "+object.getString("last_name");
                    url_facebook_get_data=  "https://graph.facebook.com/" +object1.getString("id")+ "" + "/picture?type=large";
                    email_facebook_get_data=object1.getString("email");
                    Log.d("data_object", name_facebook_get_data+url_facebook_get_data );
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                upDataFb();
                sharedPreferences = getSharedPreferences("name_login", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", name_facebook_get_data);
                editor.putString("url", url_facebook_get_data);
                editor.putString("email",email_facebook_get_data);
                editor.putString("check", null);
                Toast.makeText(getApplicationContext(), "Saving", Toast.LENGTH_SHORT).show();
                editor.commit();
                //
                if(name_facebook_get_data!=null){
                    showQuestionDialogFb();
                }
                Log.d("data_object_share", name_facebook_get_data+url_facebook_get_data );

            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email,last_name,first_name,picture.type(large),updated_time");
        request.setParameters(parameters);
        request.executeAsync();

    }


}